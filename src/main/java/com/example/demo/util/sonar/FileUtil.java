package com.example.demo.util.sonar;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName: FileUtil
 * @author: fang.xu
 * @date: 2023/6/24 14:14
 * @Copyright: 2018 www.dbappsecurity.com.cn. All rights reserved.
 * @Description:
 */
public class FileUtil {

    public static void deleteFile(File file){
        if(file.exists()){
            file.delete();
        }
    }

    public static void deleteDirChild(File file){
        if(file.exists()){
            file.delete();
        }
    }
    public static void deleteDirChild(String file){
        deleteDirChild(new File(file));
    }

    public static void deleteFiles(List<File> files){
        if (!Objects.isNull(files)) {
            for(File file:files){
                deleteFile(file);
            }
        }
    }

    public static void makeParentDirs(File file){
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }

    public static void makeParentDirs(String fileName){
        File file = new File(fileName);
        makeParentDirs(file);
    }
    /**
     * 删除文件夹以及文件夹里面内容
     * @param folderPath
     */
    public static void delFolder(String folderPath) {
        try {
            //删除完里面所有内容
            delAllFile(folderPath);
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 只删除文件夹里面内容
     */
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                //先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                //再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }

    /****
     * Deletes all contents within the specified directory without deleting the directory itself.
     *
     * @param path the path to the directory whose contents are to be deleted
     * @return true if any subdirectories were deleted; false otherwise
     */
    public static boolean delAllFile2(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                //先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                //再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Deletes all contents within the specified directory without deleting the directory itself.
     *
     * @param path the path to the directory whose contents are to be deleted
     * @return {@code true} if any subdirectories were deleted; {@code false} otherwise
     */
    public static boolean delAllFile3(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                //先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                //再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Deletes all contents within the specified directory without deleting the directory itself.
     *
     * @param path the path to the directory whose contents are to be deleted
     * @return {@code true} if any subdirectories were deleted; {@code false} otherwise
     */
    public static boolean delAllFile4(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                //先删除文件夹里面的文件
                delAllFile(path + "/" + tempList[i]);
                //再删除空文件夹
                delFolder(path + "/" + tempList[i]);
                flag = true;
            }
        }
        return flag;
    }
}
