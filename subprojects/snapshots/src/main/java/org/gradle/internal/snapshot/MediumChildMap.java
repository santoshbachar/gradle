/*
 * Copyright 2020 the original author or authors.
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

package org.gradle.internal.snapshot;

import java.util.List;

public class MediumChildMap<T> extends AbstractListChildMap<T> {
    protected MediumChildMap(List<Entry<T>> children) {
        super(children);
    }

    @Override
    public <R> R getNode(VfsRelativePath targetPath, CaseSensitivity caseSensitivity, GetNodeHandler<T, R> handler) {
        for (Entry<T> entry : children) {
            String childPath = entry.getPath();
            T child = entry.getValue();
            if (targetPath.hasPrefix(childPath, caseSensitivity)) {
                if (targetPath.length() == childPath.length()) {
                    return handler.handleExactMatchWithChild(child);
                } else {
                    return handler.handleAsDescendantOfChild(targetPath.fromChild(childPath), child);
                }
            } else if (targetPath.length() < childPath.length() && targetPath.isPrefixOf(childPath, caseSensitivity)) {
                return handler.handleAsAncestorOfChild(childPath, child);
            }
        }
        return handler.handleUnrelatedToAnyChild();
    }
}
