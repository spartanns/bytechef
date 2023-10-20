
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

package com.bytechef.hermes.connection.service.impl;

import com.bytechef.hermes.connection.domain.Connection;
import com.bytechef.hermes.connection.repository.ConnectionRepository;
import com.bytechef.hermes.connection.service.ConnectionService;
import com.bytechef.tag.domain.Tag;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.List;
import java.util.Objects;
import java.util.stream.StreamSupport;

import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * @author Ivica Cardic
 */
@Transactional
public class ConnectionServiceImpl implements ConnectionService {

    private final ConnectionRepository connectionRepository;

    @SuppressFBWarnings("EI2")
    public ConnectionServiceImpl(ConnectionRepository connectionRepository) {
        this.connectionRepository = connectionRepository;
    }

    @Override
    public Connection create(@NonNull Connection connection) {
        Assert.notNull(connection, "'connection' must not be null");
        Assert.hasText(connection.getComponentName(), "'componentName' must not be empty");
        Assert.hasText(connection.getName(), "'name' must not be empty");

        return connectionRepository.save(connection);
    }

    @Override
    public void delete(long id) {
        connectionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Connection getConnection(long id) {
        return connectionRepository.findById(id)
            .orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Connection> getConnections(List<String> componentNames, List<Long> tagIds) {
        Iterable<Connection> connectionIterable;

        if (CollectionUtils.isEmpty(componentNames) && CollectionUtils.isEmpty(tagIds)) {
            connectionIterable = connectionRepository.findAll();
        } else if (!CollectionUtils.isEmpty(componentNames) && CollectionUtils.isEmpty(tagIds)) {
            connectionIterable = connectionRepository.findByComponentNameIn(componentNames);
        } else if (CollectionUtils.isEmpty(componentNames)) {
            connectionIterable = connectionRepository.findByTagIdIn(tagIds);
        } else {
            connectionIterable = connectionRepository.findByComponentNamesAndTagIds(componentNames, tagIds);
        }

        return StreamSupport.stream(connectionIterable.spliterator(), false)
            .toList();
    }

    @Override
    public Connection update(Long id, List<Tag> tags) {
        Connection connection = getConnection(id);

        connection.setTags(tags);

        return connectionRepository.save(connection);
    }

    @Override
    @SuppressFBWarnings("NP")
    public Connection update(@NonNull Connection connection) {
        Assert.notNull(connection, "'connection' must not be null");
        Assert.hasText(connection.getComponentName(), "'componentName' must not be empty");
        Assert.hasText(connection.getName(), "'name' must not be empty");

        return connectionRepository
            .findById(Objects.requireNonNull(connection.getId()))
            .map(curConnection -> {
                curConnection.setName(connection.getName());
                curConnection.setVersion(connection.getVersion());

                return connectionRepository.save(curConnection);
            })
            .orElseThrow();
    }
}
