/*
 * Copyright 2023 the original author or authors.
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

package org.gradle.test.preconditions

import org.gradle.api.JavaVersion
import org.gradle.integtests.fixtures.AvailableJavaHomes
import org.gradle.integtests.fixtures.executer.GradleContextualExecuter
import org.gradle.test.precondition.TestPrecondition

class IntegTestPreconditions {

    static final class IsLongLivingProcess implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isLongLivingProcess()
        }
    }

    static final class IsEmbeddedExecutor implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isEmbedded()
        }
    }

    static final class NotEmbeddedExecutor implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return notSatisfied(IsEmbeddedExecutor)
        }
    }

    static final class NotEmbeddedExecutorOrNotWindows implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return notSatisfied(IsEmbeddedExecutor) || notSatisfied(UnitTestPreconditions.Windows)
        }
    }


    static final class IsDaemonExecutor implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isDaemon()
        }
    }

    static final class NotDaemonExecutor implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isNoDaemon()
        }
    }

    static final class NotParallelExecutor implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return !GradleContextualExecuter.isParallel()
        }
    }

    static final class IsConfigCached implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isConfigCache()
        }
    }

    static final class NotConfigCached implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return GradleContextualExecuter.isNotConfigCache()
        }
    }

    static class Java7HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(7)
            )
        }
    }

    /**
     * A JVM that doesn't support running the current Gradle version is available.
     */
    static class UnsupportedJavaHomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return !AvailableJavaHomes.getJdks(
                JavaVersion.toVersion(6),
                JavaVersion.toVersion(7)
            ).empty
        }
    }

    static class Java8HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(8)
            )
        }
    }

    static class MoreThanOneJava8HomeAvailable implements  TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getAvailableJdks(
                JavaVersion.toVersion(8)
            ).size() > 1
        }
    }

    static class Java9HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(9)
            )
        }
    }

    static class Java10HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(10)
            )
        }
    }

    static class Java11HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(11)
            )
        }
    }

    static class Java12HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(12)
            )
        }
    }

    static class Java13HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(13)
            )
        }
    }

    static class Java14HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(14)
            )
        }
    }

    static class Java15HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(15)
            )
        }
    }

    static class Java16HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(16)
            )
        }
    }

    static class Java17HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(17)
            )
        }
    }

    static class Java18HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(18)
            )
        }
    }

    static class Java19HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(19)
            )
        }
    }

    static class Java20HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(20)
            )
        }
    }

    static class Java21HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(21)
            )
        }
    }

    static class Java22HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(22)
            )
        }
    }

    static class Java23HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(23)
            )
        }
    }

    static class Java24HomeAvailable implements TestPrecondition {
        @Override
        boolean isSatisfied() throws Exception {
            return AvailableJavaHomes.getJdk(
                JavaVersion.toVersion(24)
            )
        }
    }

    static final class HasMsBuild implements TestPrecondition {
        @Override
        boolean isSatisfied() {
            // Simplistic approach at detecting MSBuild by assuming Windows imply MSBuild is present
            return satisfied(UnitTestPreconditions.Windows) && notSatisfied(IsEmbeddedExecutor)
        }
    }

    static final class CanPublishToS3 implements TestPrecondition {
        @Override
        boolean isSatisfied() {
            // The S3 publish tests require the following
            return satisfied(UnitTestPreconditions.Jdk9OrLater) || notSatisfied(IsEmbeddedExecutor)
        }
    }
}
