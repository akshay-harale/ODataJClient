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
import java.net.URI;

public abstract class AbstractODataObjectFactory implements ODataObjectFactory {

    private static final long serialVersionUID = -3769695665946919447L;

    protected final ODataClient client;

    public AbstractODataObjectFactory(final ODataClient client) {
        this.client = client;
    }

    /**
     * Instantiates a new entity set.
     *
     * @return entity set.
     */
    @Override
    public ODataEntitySet newEntitySet() {
        return new ODataEntitySet();
    }

    /**
     * Instantiates a new entity set.
     *
     * @param next next link.
     * @return entity set.
     */
    @Override
    public ODataEntitySet newEntitySet(final URI next) {
        return new ODataEntitySet(next);
    }

    /**
     * Instantiates a new entity.
     *
     * @param name OData entity name.
     * @return entity.
     */
    @Override
    public ODataEntity newEntity(final String name) {
        return new ODataEntity(name);
    }

    /**
     * Instantiates a new entity.
     *
     * @param name OData entity name.
     * @param link self link.
     * @return entity.
     */
    @Override
    public ODataEntity newEntity(final String name, final URI link) {
        final ODataEntity result = new ODataEntity(name);
        result.setLink(link);
        return result;
    }

    /**
     * Instantiates a new in-line entity set.
     *
     * @param name name.
     * @param link edit link.
     * @param entitySet entity set.
     * @return in-line entity set.
     */
    @Override
    public ODataInlineEntitySet newInlineEntitySet(final String name, final URI link,
            final ODataEntitySet entitySet) {

        return new ODataInlineEntitySet(client, link, ODataLinkType.ENTITY_SET_NAVIGATION, name, entitySet);
    }

    /**
     * Instantiates a new in-line entity set.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @param entitySet entity set.
     * @return in-line entity set.
     */
    @Override
    public ODataInlineEntitySet newInlineEntitySet(final String name, final URI baseURI, final String href,
            final ODataEntitySet entitySet) {

        return new ODataInlineEntitySet(client, baseURI, href, ODataLinkType.ENTITY_SET_NAVIGATION, name, entitySet);
    }

    /**
     * Instantiates a new in-line entity.
     *
     * @param name name.
     * @param link edit link.
     * @param entity entity.
     * @return in-line entity.
     */
    @Override
    public ODataInlineEntity newInlineEntity(final String name, final URI link, final ODataEntity entity) {
        return new ODataInlineEntity(client, link, ODataLinkType.ENTITY_NAVIGATION, name, entity);
    }

    /**
     * Instantiates a new in-line entity.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @param entity entity.
     * @return in-line entity.
     */
    @Override
    public ODataInlineEntity newInlineEntity(final String name, final URI baseURI, final String href,
            final ODataEntity entity) {

        return new ODataInlineEntity(client, baseURI, href, ODataLinkType.ENTITY_NAVIGATION, name, entity);
    }

    /**
     * Instantiates a new entity navigation link.
     *
     * @param name name.
     * @param link link.
     * @return entity navigation link.
     */
    @Override
    public ODataLink newEntityNavigationLink(final String name, final URI link) {
        return new ODataLink(client, link, ODataLinkType.ENTITY_NAVIGATION, name);
    }

    /**
     * Instantiates a new entity navigation link.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @return entity navigation link.
     */
    @Override
    public ODataLink newEntityNavigationLink(final String name, final URI baseURI, final String href) {
        return new ODataLink(client, baseURI, href, ODataLinkType.ENTITY_NAVIGATION, name);
    }

    /**
     * Instantiates a new entity set navigation link.
     *
     * @param name name.
     * @param link link.
     * @return entity set navigation link.
     */
    @Override
    public ODataLink newFeedNavigationLink(final String name, final URI link) {
        return new ODataLink(client, link, ODataLinkType.ENTITY_SET_NAVIGATION, name);
    }

    /**
     * Instantiates a new entity set navigation link.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @return entity set navigation link.
     */
    @Override
    public ODataLink newFeedNavigationLink(final String name, final URI baseURI, final String href) {
        return new ODataLink(client, baseURI, href, ODataLinkType.ENTITY_SET_NAVIGATION, name);
    }

    /**
     * Instantiates a new association link.
     *
     * @param name name.
     * @param link link.
     * @return association link.
     */
    @Override
    public ODataLink newAssociationLink(final String name, final URI link) {
        return new ODataLink(client, link, ODataLinkType.ASSOCIATION, name);
    }

    /**
     * Instantiates a new association link.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @return association link.
     */
    @Override
    public ODataLink newAssociationLink(final String name, final URI baseURI, final String href) {
        return new ODataLink(client, baseURI, href, ODataLinkType.ASSOCIATION, name);
    }

    /**
     * Instantiates a new media-edit link.
     *
     * @param name name.
     * @param link link.
     * @return media-edit link.
     */
    @Override
    public ODataLink newMediaEditLink(final String name, final URI link) {
        return new ODataLink(client, link, ODataLinkType.MEDIA_EDIT, name);
    }

    /**
     * Instantiates a new media-edit link.
     *
     * @param name name.
     * @param baseURI base URI.
     * @param href href.
     * @return media-edit link.
     */
    @Override
    public ODataLink newMediaEditLink(final String name, final URI baseURI, final String href) {
        return new ODataLink(client, baseURI, href, ODataLinkType.MEDIA_EDIT, name);
    }

    /**
     * Instantiates a new primitive property.
     *
     * @param name name.
     * @param value value.
     * @return primitive property.
     */
    @Override
    public ODataProperty newPrimitiveProperty(final String name, final ODataPrimitiveValue value) {
        return new ODataProperty(name, value);
    }

    /**
     * Instantiates a new complex property.
     *
     * @param name name.
     * @param value value.
     * @return complex property.
     */
    @Override
    public ODataProperty newComplexProperty(final String name, final ODataComplexValue value) {
        return new ODataProperty(name, value);
    }

    /**
     * Instantiates a new collection property.
     *
     * @param name name.
     * @param value value.
     * @return collection property.
     */
    @Override
    public ODataProperty newCollectionProperty(final String name, final ODataCollectionValue value) {
        return new ODataProperty(name, value);
    }

}
