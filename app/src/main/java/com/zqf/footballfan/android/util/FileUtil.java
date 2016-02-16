package com.zqf.footballfan.android.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by liyan on 16/2/5.
 */
public class FileUtil {

    /**
     * 将流写入sd卡文件
     *
     * @param path
     * @param input
     *
     * @return
     *
     * @throws IOException
     */
    public static File write2SDFromInput(String path, InputStream input) throws IOException {
        File file = null;
        BufferedInputStream bis;
        OutputStream output = null;
        try {
            file = new File(path);
            if (file.exists()) {
                file.delete();
            }
            if (!file.createNewFile()) {
                return null;
            }
            output = new FileOutputStream(file);
            byte buffer[] = new byte[1024];
            bis = new BufferedInputStream(input);
            int len;
            while ((len = bis.read(buffer)) != -1) {
                output.write(buffer, 0, len);
            }
            output.flush();
        } catch (IOException e) {
            file = null;
            e.printStackTrace();
            throw e;
        } finally {
            try {
                output.close();
            } catch (Exception e) {
                file = null;
                e.printStackTrace();
            }
            try {
                input.close();
            } catch (Exception e) {
                file = null;
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 删除该目录下所有文件，
     *
     * @param file
     *
     * @return
     */
    public static boolean delete(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delete(f);
            }
            // 在FAT32类型的储存设备上，必须重命名之后删除，否则下次下载到该位置会报错
            // see:http://stackoverflow.com/questions/11539657/open-failed-ebusy-device-or-resource-busy
            File newFile = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(newFile);
            return newFile.delete();
        } else {
            // 在FAT32类型的储存设备上，必须重命名之后删除，否则下次下载到该位置会报错
            // see:http://stackoverflow.com/questions/11539657/open-failed-ebusy-device-or-resource-busy
            File newFile = new File(file.getAbsolutePath() + System.currentTimeMillis());
            file.renameTo(newFile);
            return newFile.delete();
        }
    }

    /**
     * 确保文件夹存在，不存在则创建
     *
     * @param path
     */
    public static void ensurePathExist(String path) {
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
    }

    /**
     * 保证文件存在，不存在则创建.
     *
     * @param path
     *
     * @throws IOException
     */
    public static void ensureFileExist(String path) throws IOException {
        File file = new File(path);
        if (!file.exists() && !file.isFile()) {
            String parent = file.getParent();
            ensurePathExist(parent);
            file.createNewFile();
        }
    }

    /**
     * 保存文本至指定目录.
     *
     * @param text
     * @param path
     */
    public static void saveText(String text, String path) {
        FileWriter writer = null;
        try {
            ensureFileExist(path);
            writer = new FileWriter(path);
            writer.write(text);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从指定文件读取文本.
     *
     * @param path
     *
     * @return
     */
    public static String read(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            StringWriter writer = new StringWriter();
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            return writer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * @return 目录下文件大小
     */
    public static long getFileSize(String filepath) {
        long size = 0;
        File file = new File(filepath);
        if (!file.exists()) {
            return -1;
        }
        File[] fileList = file.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                size += getFileSize(fileList[i].getAbsolutePath());
            } else {
                size += fileList[i].length();
            }
        }

        return size;
    }

    /* 文件复制 */
    public static void copyFile(String sourceFile, String targetFile) {
        InputStream is = null;
        OutputStream os = null;
        try {
            File sf = new File(sourceFile);
            File tf = new File(targetFile);
            if (tf != null && !tf.exists()) {
                tf.createNewFile();
            }
            is = new FileInputStream(sf);
            os = new FileOutputStream(tf);
            int defaultBufferSize = 1024 * 4;
            byte[] buffer = new byte[defaultBufferSize];
            int n = 0;
            while (-1 != (n = is.read(buffer))) {
                os.write(buffer, 0, n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 递归解压所以文件及文件夹
     *
     * @param src
     * @param des
     *
     * @throws IOException
     */
    public static void unZip(String src, String des) throws IOException {
        ZipFile file = null;
        FileOutputStream fout = null;
        DataOutputStream dout = null;
        boolean error = false;
        try {
            File dir = new File(des);
            if (dir.exists()) {
                delete(dir);
            }
            dir.mkdirs();
            file = new ZipFile(src);
            InputStream in = null;
            des = des.replace('/', '/');
            if (des.startsWith("//")) {
                des = des.replaceFirst("//", "//");
            }
            Enumeration en = file.entries();
            while (en.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) en.nextElement();
                if (entry.isDirectory()) {// 文件夹
                    File directory = new File(des + "/" + entry.getName());
                    if (!directory.exists()) {
                        directory.mkdirs();
                    }
                } else {// 文件
                    String path = entry.getName();
                    path = path.replace('/', '/');
                    if (path.startsWith("//")) {
                        path = path.replaceFirst("//", "//");
                    }
                    int pos = path.lastIndexOf('/');
                    if (pos != -1) {
                        path = path.substring(0, pos + 1);
                        File d = new File(des + "/" + path);
                        if (!d.exists()) {
                            d.mkdirs();
                        }
                    }
                    try {
                        File files = new File(entry.getName());
                        File f = new File(des + "/" + files.getPath());
                        if (f.exists()) {
                            f.delete();
                        }
                        f.createNewFile();
                        fout = new FileOutputStream(f);
                        dout = new DataOutputStream(fout);
                        in = file.getInputStream(entry);
                        byte[] b = new byte[4096];
                        int len = 0;
                        while ((len = in.read(b)) != -1) {
                            dout.write(b, 0, len);
                        }
                    } catch (IOException e) {
                        throw e;
                    } finally {
                        IoUtil.closeStream(fout);
                        IoUtil.closeStream(dout);
                        IoUtil.closeStream(in);
                    }
                }
            }
        } catch (IOException e) {
            error = true;
            throw e;
        } finally {
            if (file != null) {
                file.close();
            }
            IoUtil.closeStream(fout);
            IoUtil.closeStream(dout);
            delete(new File(src));
            if (error) {
                delete(new File(des));
                delete(new File(src));
            }
        }
    }

}
