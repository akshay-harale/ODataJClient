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
package com.msopentech.odatajclient.engine.v4;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.msopentech.odatajclient.engine.AbstractTest;
import com.msopentech.odatajclient.engine.client.ODataV4Client;
import com.msopentech.odatajclient.engine.data.ODataServiceDocument;
import com.msopentech.odatajclient.engine.format.ODataFormat;
import org.junit.Ignore;
import org.junit.Test;

public class V4JSONServiceDocumentTest extends AbstractTest {

    @Override
    protected ODataV4Client getClient() {
        return v4Client;
    }

    protected ODataFormat getFormat() {
        return ODataFormat.JSON;
    }

    private String getFileExtension() {
        return getFormat() == ODataFormat.XML ? "xml" : "json";
    }

    @Test
    @Ignore
    public void parse() {
        final ODataServiceDocument serviceDocument = getClient().getReader().readServiceDocument(
                getClass().getResourceAsStream("serviceDocument." + getFileExtension()), getFormat());
        assertNotNull(serviceDocument);
        assertTrue(serviceDocument.getEntitySetNames().contains("Persons"));
    }
}
