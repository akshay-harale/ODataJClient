/*
 * Copyright 2013 MS OpenTech.
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
package com.msopentech.odatajclient.engine.data;

import java.util.ArrayList;
import java.util.List;

/**
 * OData feed.
 */
public class ODataFeed {

    /**
     * Link to the next page.
     */
    protected ODataURI next;

    /**
     * Feed entries.
     */
    protected List<ODataEntity> entities = new ArrayList<ODataEntity>();

    /**
     * Gets next page link.
     *
     * @return next page link; null value if single page or last page reached.
     */
    public ODataURI getNext() {
        return next;
    }

    /**
     * Gets feed entries.
     *
     * @return feed entries.
     */
    public List<ODataEntity> getEntities() {
        return entities;
    }
}
