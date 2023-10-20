
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

package com.bytechef.hermes.data.storage.db.config;

import com.bytechef.hermes.data.storage.db.repository.DataStorageRepository;
import com.bytechef.hermes.data.storage.db.service.DbDataStorageService;
import com.bytechef.hermes.data.storage.service.DataStorageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ivica Cardic
 */
@Configuration
@ConditionalOnProperty(prefix = "bytechef.data-storage", name = "provider", havingValue = "db")
public class DbDataStorageConfiguration {

    @Bean
    DataStorageService dataStorageService(DataStorageRepository dataStorageRepository) {
        return new DbDataStorageService(dataStorageRepository);
    }
}
