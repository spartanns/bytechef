/*
 * Copyright 2021 <your company/name>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.task.handler.httpclient.v1_0.auth;

import static com.bytechef.task.handler.httpclient.HttpClientTaskConstants.AuthType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matija Petanjek
 * @author Ivica Cardic
 */
public class AuthResolverRegistry {

    private static final Map<AuthType, AuthResolver> HTTP_AUTH_MAP = new HashMap<>() {
        {
            put(AuthType.API_KEY, new ApiKeyAuthResolver());
            put(AuthType.BASIC_AUTH, new BasicAuthResolver());
            put(AuthType.BEARER_TOKEN, new BearerTokenAuthResolver());
            put(AuthType.DIGEST_AUTH, new DigestAuthResolver());
            put(AuthType.OAUTH2, new OAuth2AuthResolver());
        }
    };

    public static AuthResolver get(AuthType authType) {
        return HTTP_AUTH_MAP.get(authType);
    }
}
