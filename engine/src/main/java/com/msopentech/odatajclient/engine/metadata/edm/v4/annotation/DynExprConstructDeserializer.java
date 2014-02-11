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
package com.msopentech.odatajclient.engine.metadata.edm.v4.annotation;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.msopentech.odatajclient.engine.metadata.edm.AbstractEdmDeserializer;
import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

public class DynExprConstructDeserializer extends AbstractEdmDeserializer<DynExprConstruct> {

    private static final String[] EL_OR_ATTR = { AnnotationPath.class.getSimpleName(), Path.class.getSimpleName() };

    private static final String APPLY = Apply.class.getSimpleName();

    private static final String CAST = Cast.class.getSimpleName();

    private static final String COLLECTION = Collection.class.getSimpleName();

    private static final String IF = If.class.getSimpleName();

    private static final String IS_OF = IsOf.class.getSimpleName();

    private static final String LABELED_ELEMENT = LabeledElement.class.getSimpleName();

    private static final String NULL = Null.class.getSimpleName();

    private static final String RECORD = Record.class.getSimpleName();

    private static final String URL_REF = UrlRef.class.getSimpleName();

    private AbstractElOrAttrConstruct getElOrAttrInstance(final String simpleClassName) throws JsonParseException {
        try {
            @SuppressWarnings("unchecked")
            Class<? extends AbstractElOrAttrConstruct> elOrAttrClass =
                    (Class<? extends AbstractElOrAttrConstruct>) ClassUtils.getClass(
                            getClass().getPackage().getName() + "." + simpleClassName);
            return elOrAttrClass.newInstance();
        } catch (Exception e) {
            throw new JsonParseException("Could not instantiate " + simpleClassName, JsonLocation.NA);
        }
    }

    private ExprConstruct parseConstOrEnumExprConstruct(final JsonParser jp) throws IOException {
        ExprConstruct result;
        if (isAnnotationConstExprConstruct(jp)) {
            result = parseAnnotationConstExprConstruct(jp);
        } else {
            result = jp.getCodec().readValue(jp, DynExprConstruct.class);
        }
        jp.nextToken();

        return result;
    }

    @Override
    protected DynExprConstruct doDeserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        DynExprConstruct construct = null;

        if (DynExprSingleParamOp.Type.fromString(jp.getCurrentName()) != null) {
            final DynExprSingleParamOp dynExprSingleParamOp = new DynExprSingleParamOp();
            dynExprSingleParamOp.setType(DynExprSingleParamOp.Type.fromString(jp.getCurrentName()));

            jp.nextToken();
            jp.nextToken();
            dynExprSingleParamOp.setExpression(jp.getCodec().readValue(jp, DynExprConstruct.class));

            construct = dynExprSingleParamOp;
        } else if (DynExprDoubleParamOp.Type.fromString(jp.getCurrentName()) != null) {
            final DynExprDoubleParamOp dynExprDoubleParamOp = new DynExprDoubleParamOp();
            dynExprDoubleParamOp.setType(DynExprDoubleParamOp.Type.fromString(jp.getCurrentName()));

            jp.nextToken();
            jp.nextToken();
            dynExprDoubleParamOp.setLeft(jp.getCodec().readValue(jp, DynExprConstruct.class));
            dynExprDoubleParamOp.setRight(jp.getCodec().readValue(jp, DynExprConstruct.class));

            construct = dynExprDoubleParamOp;
        } else if (ArrayUtils.contains(EL_OR_ATTR, jp.getCurrentName())) {
            final AbstractElOrAttrConstruct elOrAttr = getElOrAttrInstance(jp.getCurrentName());
            elOrAttr.setValue(jp.nextTextValue());

            construct = elOrAttr;
        } else if (APPLY.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, Apply.class);
        } else if (CAST.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, Cast.class);
        } else if (COLLECTION.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, Collection.class);
        } else if (IF.equals(jp.getCurrentName())) {
            jp.nextToken();
            jp.nextToken();

            final If _if = new If();
            _if.setGuard(parseConstOrEnumExprConstruct(jp));
            _if.setThen(parseConstOrEnumExprConstruct(jp));
            _if.setElse(parseConstOrEnumExprConstruct(jp));

            construct = _if;
        } else if (IS_OF.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, IsOf.class);
        } else if (LABELED_ELEMENT.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, LabeledElement.class);
        } else if (NULL.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, Null.class);
        } else if (RECORD.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, Record.class);
        } else if (URL_REF.equals(jp.getCurrentName())) {
            jp.nextToken();
            construct = jp.getCodec().readValue(jp, UrlRef.class);
        }

        return construct;
    }
}
