/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bootstack.web.common;

import com.bootstack.web.template.JsonTemplate;
import lombok.Data;
import lombok.ToString;

/**
 * <p> ResponseResult </p>
 * <p> Description : ResponseResult </p>
 * <p> Author : qianmoQ </p>
 * <p> Version : 1.0 </p>
 * <p> Create Time : 2019-01-25 16:56 </p>
 * <p> Author Email: <a href="mailTo:shichengoooo@163.com">qianmoQ</a> </p>
 */
@Data
@ToString
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;

    private static JsonTemplate template = new JsonTemplate();

    public static ResponseResult getResponse(String result, String defaultPath) {
        ResponseResult response = new ResponseResult();
        response.setCode(template.getJsonObject(result).getInteger("code"));
        response.setMessage(template.getJsonObject(result).getString("message"));
        response.setData(template.getJsonObject(result).getString("data"));
        return response;
    }

}