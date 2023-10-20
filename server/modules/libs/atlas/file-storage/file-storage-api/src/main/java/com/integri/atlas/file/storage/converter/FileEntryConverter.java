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

package com.integri.atlas.file.storage.converter;

import com.integri.atlas.file.storage.FileEntry;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;

/**
 * @author Ivica Cardic
 */
public class FileEntryConverter implements Converter<Map<?, ?>, FileEntry> {

    @Override
    @SuppressWarnings("unchecked")
    public FileEntry convert(Map<?, ?> source) {
        return FileEntry.of((Map<String, String>) source);
    }
}
