/*
 * Copyright (2020) The Delta Lake Project Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.delta.standalone.actions;

import java.util.Objects;

/** Represents the Databricks Job information that committed to the Delta table. */
public class JobInfo implements Action {
    private final String jobId;
    private final String jobName;
    private final String runId;
    private final String jobOwnerId;
    private final String triggerType;

    public JobInfo(String jobId, String jobName, String runId, String jobOwnerId, String triggerType) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.runId = runId;
        this.jobOwnerId = jobOwnerId;
        this.triggerType = triggerType;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getRunId() {
        return runId;
    }

    public String getJobOwnerId() {
        return jobOwnerId;
    }

    public String getTriggerType() {
        return triggerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobInfo jobInfo = (JobInfo) o;
        return Objects.equals(jobId, jobInfo.jobId) &&
                Objects.equals(jobName, jobInfo.jobName) &&
                Objects.equals(runId, jobInfo.runId) &&
                Objects.equals(jobOwnerId, jobInfo.jobOwnerId) &&
                Objects.equals(triggerType, jobInfo.triggerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobName, runId, jobOwnerId, triggerType);
    }

    /**
     * @return a new {@code JobInfo.Builder}
     */
    public static Builder builder(String jobId) {
        return new Builder(jobId);
    }

    /**
     * Builder class for JobInfo. Enables construction of JobInfo object with default values.
     */
    public static class Builder {
        // required JobInfo fields
        private final String jobId;
        // optional JobInfo fields
        private String jobName;
        private String runId;
        private String jobOwnerId;
        private String triggerType;

        public Builder(String jobId) {
            this.jobId = jobId;
        }

        public Builder jobName(String jobName) {
            this.jobName = jobName;
            return this;
        }

        public Builder runId(String runId) {
            this.runId = runId;
            return this;
        }

        public Builder jobOwnerId(String jobOwnerId) {
            this.jobOwnerId = jobOwnerId;
            return this;
        }

        public Builder triggerType(String triggerType) {
            this.triggerType = triggerType;
            return this;
        }

        /**
         * @return a new {@code JobInfo} with the same properties as {@code this}
         */
        public JobInfo build() {
            JobInfo jobInfo = new JobInfo(this.jobId, this.jobName, this.runId, this.jobOwnerId,
                    this.triggerType);
            return jobInfo;
        }
    }
}
