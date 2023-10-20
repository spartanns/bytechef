/*
 * Copyright 2016-2018 the original author or authors.
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
 *
 * Modifications copyright (C) 2021 <your company/name>
 */

package com.integri.atlas.engine.coordinator.job.repository;

import com.integri.atlas.engine.coordinator.data.Page;
import com.integri.atlas.engine.coordinator.job.Job;
import com.integri.atlas.engine.coordinator.job.JobSummary;
import java.util.List;
import java.util.Optional;

/**
 * @author Arik Cohen
 * @author Ivica Cardic
 */
public interface JobRepository {
    int countCompletedJobsToday();

    int countCompletedJobsYesterday();

    int countRunningJobs();

    void create(Job aJob);

    void delete(String id);

    List<Job> findAll();

    Page<JobSummary> getPage(int aPageNumber);

    Job getById(String aId);

    Optional<Job> getLatest();

    Job getByTaskId(String aTaskId);

    Job merge(Job aJob);
}
