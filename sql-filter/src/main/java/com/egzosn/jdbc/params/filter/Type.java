/*
 * Copyright 2002-2020 the original  egan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.egzosn.jdbc.params.filter;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by egan on 2015/12/1.
 * 类型简化集
 */
public enum  Type {

    i {
        public Object parse(String parse) {
           return Integer.parseInt(parse);
        }
    }, f {
        public Object parse(String parse) {
           return Float.parseFloat(parse);
        }
    }, d {
        public Object parse(String parse) {
           return Double.parseDouble(parse);
        }
   }, s {
        public Object parse(String parse) {
           return Short.parseShort(parse);
        }
    }, S {
        public Object parse(String parse) {
           return parse;
        }
   }, D {
        public Object parse(String parse) {
            try {
                if (parse.contains(" ")){
                    return dtf.parse(parse);
                }
                return df.parse(parse);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date(parse);
        }
  }, b {
        public Object parse(String parse) {
           return Boolean.parseBoolean(parse);
        }
  }, bd {
        public Object parse(String parse) {
           return new BigDecimal(parse);
        }
    };

    public static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    public static final DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        df.setTimeZone(timeZone);
        dtf.setTimeZone(timeZone);
    }
    public abstract Object parse(String parse);
}
