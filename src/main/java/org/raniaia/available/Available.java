package org.raniaia.available;

/*
 * Copyright (C) 2020 Tiansheng All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Creates on 2020/4/22.
 */

import org.raniaia.available.io.file.Files;

import java.io.File;

/**
 * @author tiansheng
 */
public class Available {

    public static Encrypt encrypt = new Encrypt();

    /**
     * 加密算法
     *
     * @author tiansheng
     */
    static class Encrypt {

        private Encrypt(){}

        /**
         * 对文件进行简单的加密
         */
        public void encrypt(File file){
            byte[] bytes = Files.fileToBytes(file);
            for(int i=0; i<bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] + 16);
            }
            Files.bytesToFile(new File(file.getParentFile().getPath().concat("\\").concat(file.getName().concat(".ec"))),bytes);
        }

        /**
         * 对文件进行解密
         */
        public void decrypt(File file){
            byte[] bytes = Files.fileToBytes(file);
            for(int i=0; i<bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] - 16);
            }
            Files.bytesToFile(new File(file.getParentFile().getPath().concat("\\").concat(file.getName().concat(".dc.mp4"))),bytes);
        }

    }

}
