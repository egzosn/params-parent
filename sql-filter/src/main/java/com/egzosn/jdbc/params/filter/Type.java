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
import java.util.Date;

/**
 * Created by egan on 2015/12/1.
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

    public abstract Object parse(String parse);
}
