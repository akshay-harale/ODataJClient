/**
 * Copyright © Microsoft Open Technologies, Inc.
 *
 * All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * THIS CODE IS PROVIDED *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 * ANY IMPLIED WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A
 * PARTICULAR PURPOSE, MERCHANTABILITY OR NON-INFRINGEMENT.
 *
 * See the Apache License, Version 2.0 for the specific language
 * governing permissions and limitations under the License.
 */
package com.msopentech.odatajclient.engine.data;

import com.msopentech.odatajclient.engine.client.ODataClient;
import com.msopentech.odatajclient.engine.utils.ODataVersion;
import com.msopentech.odatajclient.engine.utils.URIUtils;
import java.net.URI;

/**
 * OData link.
 */
public class ODataLink extends ODataItem {

    private static final long serialVersionUID = 7274966414277952124L;

    protected final ODataClient client;

    /**
     * Link type.
     */
    protected final ODataLinkType type;

    /**
     * Link rel.
     */
    protected final String rel;

    /**
     * Constructor.
     *
     * @param client OData client.
     * @param uri URI.
     * @param type type.
     * @param title title.
     */
    ODataLink(final ODataClient client, final URI uri, final ODataLinkType type, final String title) {
        super(title);
        this.client = client;
        this.link = uri;

        this.type = type;

        switch (this.type) {
            case ASSOCIATION:
                this.rel = client.getWorkingVersion().getNamespaceMap().get(ODataVersion.ASSOCIATION_LINK_REL) + title;
                break;

            case ENTITY_NAVIGATION:
            case ENTITY_SET_NAVIGATION:
                this.rel = client.getWorkingVersion().getNamespaceMap().get(ODataVersion.NAVIGATION_LINK_REL) + title;
                break;

            case MEDIA_EDIT:
            default:
                this.rel = client.getWorkingVersion().getNamespaceMap().get(ODataVersion.MEDIA_EDIT_LINK_REL) + title;
                break;
        }
    }

    /**
     * Constructor.
     *
     * @param client OData client.
     * @param baseURI base URI.
     * @param href href.
     * @param type type.
     * @param title title.
     */
    ODataLink(
            final ODataClient client, final URI baseURI, final String href, final ODataLinkType type, final String title) {

        this(client, URIUtils.getURI(baseURI, href), type, title);
    }

    /**
     * Gets link type.
     *
     * @return link type;
     */
    public ODataLinkType getType() {
        return type;
    }

    /**
     * Gets link rel.
     *
     * @return link rel
     */
    public String getRel() {
        return rel;
    }
}
