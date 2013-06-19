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
package com.msopentech.odatajclient.engine.utils;

import com.msopentech.odatajclient.engine.data.ODataEntity;
import com.msopentech.odatajclient.engine.data.ODataFeed;
import com.msopentech.odatajclient.engine.data.ODataLink;
import com.msopentech.odatajclient.engine.data.ODataLinkType;
import java.net.URI;
import java.util.List;

public class ODataFactory {

    public static ODataFeed newFeed(final List<ODataEntity> entries) {
        return new FeedImpl(entries);
    }

    public static ODataFeed newFeed(final List<ODataEntity> entries, final URI next) {
        return new FeedImpl(entries, next);
    }

    public static ODataEntity newEntity(final String name) {
        return new EntityImpl(name);
    }

    public static ODataEntity newEntity(final String name, final URI link) {
        return new EntityImpl(name, link);
    }

    public static ODataLink newLink(final String name, final URI link, final ODataLinkType type) {
        return new LinkImpl(link, type, name);
    }

    public static ODataLink newLink(final String name, final URI baseURI, final String href, final ODataLinkType type) {
        return new LinkImpl(baseURI, href, type, name);
    }

    public static ODataLink newEntityNavigationLink(final String name, final URI link) {
        return new LinkImpl(link, ODataLinkType.ENTITY_NAVIGATION, name);
    }

    public static ODataLink newEntityNavigationLink(final String name, final URI baseURI, final String href) {
        return new LinkImpl(baseURI, href, ODataLinkType.ENTITY_NAVIGATION, name);
    }

    public static ODataLink newFeedNavigationLink(final String name, final URI link) {
        return new LinkImpl(link, ODataLinkType.FEED_NAVIGATION, name);
    }

    public static ODataLink newFeedNavigationLink(final String name, final URI baseURI, final String href) {
        return new LinkImpl(baseURI, href, ODataLinkType.FEED_NAVIGATION, name);
    }

    public static ODataLink newAssociationLink(final String name, final URI link) {
        return new LinkImpl(link, ODataLinkType.ASSOCIATION, name);
    }

    public static ODataLink newAssociationLink(final String name, final URI baseURI, final String href) {
        return new LinkImpl(baseURI, href, ODataLinkType.ASSOCIATION, name);
    }

    public static ODataLink newMediaEditLink(final String name, final URI link) {
        return new LinkImpl(link, ODataLinkType.MEDIA_EDIT, name);
    }

    public static ODataLink newMediaEditLink(final String name, final URI baseURI, final String href) {
        return new LinkImpl(baseURI, href, ODataLinkType.MEDIA_EDIT, name);
    }

    private static class FeedImpl extends ODataFeed {

        private static final long serialVersionUID = 1632243717538685102L;

        public FeedImpl(final List<ODataEntity> entries) {
            super();
            this.next = null;
            this.entities.addAll(entries);
        }

        public FeedImpl(final List<ODataEntity> entries, final URI next) {
            super();
            this.next = next;
            this.entities.addAll(entries);
        }
    }

    private static class EntityImpl extends ODataEntity {

        private static final long serialVersionUID = 1632243717538685102L;

        public EntityImpl(final String name) {
            super(name);
        }

        public EntityImpl(final String name, final URI link) {
            super(name);
            this.link = link;
        }
    }

    private static class LinkImpl extends ODataLink {

        private static final long serialVersionUID = -2533925527313767001L;

        public LinkImpl(final URI uri, final ODataLinkType type, final String title) {
            super(uri, type, title);
        }

        public LinkImpl(final URI baseURI, final String href, final ODataLinkType type, final String title) {
            super(baseURI, href, type, title);
        }
    }
}