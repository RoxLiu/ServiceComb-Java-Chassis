/*
 * Copyright 2017 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.servicecomb.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author   
 * @version  [版本号, 2017年2月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestMgr {
    private static Logger LOGGER = LoggerFactory.getLogger(TestMgr.class);

    private static List<Throwable> errorList = new ArrayList<>();

    private static String msg = "";

    public static void setMsg(String msg) {
        TestMgr.msg = msg;
    }

    public static void setMsg(String microserviceName, String transport) {
        TestMgr.msg = String.format("microservice=%s, transport=%s", microserviceName, transport);
    }

    public static void check(Object expect, Object real) {
        String strExpect = String.valueOf(expect);
        String strReal = String.valueOf(real);

        if (!strExpect.equals(strReal)) {
            errorList.add(new Error(msg + " | Expect " + strExpect + ", but " + strReal));
        }
    }

    public static void summary() {
        if (errorList.isEmpty()) {
            LOGGER.info("............. test finished ............");
            return;
        }

        LOGGER.info("............. test not finished ............");
        for (Throwable e : errorList) {
            LOGGER.info("", e);
        }
    }
}