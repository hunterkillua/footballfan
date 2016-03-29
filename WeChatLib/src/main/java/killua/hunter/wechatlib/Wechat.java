package killua.hunter.wechatlib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;

/**
 * Created by liyan on 16/3/29.
 */
public class Wechat {
    private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    public static IWXAPI getWechatApi(Context context) {
        return WXAPIFactory.createWXAPI(context, Constants.APP_ID, false);
    }

    public static void registerWechat(Context context) {
        getWechatApi(context).registerApp(Constants.APP_ID);
    }

    public static void shareWechat(Context context, String text) {
        IWXAPI api = getWechatApi(context);
        api.registerApp(Constants.APP_ID);
        int wxSdkVersion = api.getWXAppSupportAPI();
        if (wxSdkVersion < TIMELINE_SUPPORTED_VERSION) {
            return;
        }

        if (text == null || text.length() == 0) {
            return;
        }

        // 初始化一个WXTextObject对象
        WXTextObject textObj = new WXTextObject();
        textObj.text = text;

        // 用WXTextObject对象初始化一个WXMediaMessage对象
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        // 发送文本类型的消息时，title字段不起作用
        // msg.title = "Will be ignored";
        msg.description = text;

        // 构造一个Req
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text"); // transaction字段用于唯一标识一个请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;

        // 调用api接口发送数据到微信
        api.sendReq(req);
    }

    public static void shareWechatUrl(Context context, boolean isTimeLine, String url, String title,
                                      String dsc, Bitmap thumb) {
        IWXAPI api = getWechatApi(context);
        api.registerApp(Constants.APP_ID);

//        WXTextObject textObj = new WXTextObject();
//        textObj.text = text;

        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = dsc;
        if (thumb != null) {
            msg.thumbData = Util.bmpToByteArray(thumb, true);
        }
//        msg.mediaObject = textObj;

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = isTimeLine ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
        api.sendReq(req);
    }

    private static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
