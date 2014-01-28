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

package com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice;

import com.msopentech.odatajclient.engine.client.http.HttpMethod;
import com.msopentech.odatajclient.proxy.api.annotations.Namespace;
import com.msopentech.odatajclient.proxy.api.annotations.EntityContainer;
import com.msopentech.odatajclient.proxy.api.annotations.Operation;
import com.msopentech.odatajclient.proxy.api.annotations.Parameter;
import com.msopentech.odatajclient.engine.data.metadata.edm.v3.ParameterMode;
import com.msopentech.odatajclient.proxy.api.AbstractContainer;
import com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.*;
import com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.*;

// EdmSimpleType property imports
import com.msopentech.odatajclient.engine.data.ODataDuration;
import com.msopentech.odatajclient.engine.data.ODataTimestamp;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Geospatial;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.GeospatialCollection;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.LineString;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiLineString;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiPoint;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.MultiPolygon;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Point;
import com.msopentech.odatajclient.engine.data.metadata.edm.geospatial.Polygon;
import java.math.BigDecimal;
import java.net.URI;
import java.util.UUID;
import java.io.Serializable;
import java.util.Collection;

@Namespace("Microsoft.Test.OData.Services.AstoriaDefaultService")
@EntityContainer(name = "DefaultContainer",
  isDefaultEntityContainer = true)
public interface DefaultContainer extends AbstractContainer {

    AllGeoTypesSet getAllGeoTypesSet();

    AllGeoCollectionTypesSet getAllGeoCollectionTypesSet();

    Customer getCustomer();

    Login getLogin();

    RSAToken getRSAToken();

    PageView getPageView();

    LastLogin getLastLogin();

    Message getMessage();

    MessageAttachment getMessageAttachment();

    Order getOrder();

    OrderLine getOrderLine();

    Product getProduct();

    ProductDetail getProductDetail();

    ProductReview getProductReview();

    ProductPhoto getProductPhoto();

    CustomerInfo getCustomerInfo();

    Computer getComputer();

    ComputerDetail getComputerDetail();

    Driver getDriver();

    License getLicense();

    MappedEntityType getMappedEntityType();

    Car getCar();

    Person getPerson();

    PersonMetadata getPersonMetadata();




      @Operation(name = "RetrieveProduct"     ,
                    httpMethod = HttpMethod.POST ,
                    returnType = "Edm.Int32")
    Integer retrieveProduct(
    );
        @Operation(name = "RetrieveProduct"      ,
                    returnType = "Edm.Int32")
    Integer retrieveProduct(
        @Parameter(name = "product", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.Product", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.Product product
    );
        @Operation(name = "RetrieveProduct"      ,
                    returnType = "Edm.Int32")
    Integer retrieveProduct(
        @Parameter(name = "orderLine", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.OrderLine", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.OrderLine orderLine
    );
        @Operation(name = "IncreaseSalaries"      )
    void increaseSalaries(
        @Parameter(name = "employees", type = "Collection(Microsoft.Test.OData.Services.AstoriaDefaultService.Employee)", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.EmployeeCollection employees, 
        @Parameter(name = "n", type = "Edm.Int32", nullable = false) Integer n
    );
        @Operation(name = "IncreaseSalaries"      )
    void increaseSalaries(
        @Parameter(name = "specialEmployees", type = "Collection(Microsoft.Test.OData.Services.AstoriaDefaultService.SpecialEmployee)", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.SpecialEmployeeCollection specialEmployees, 
        @Parameter(name = "n", type = "Edm.Int32", nullable = false) Integer n
    );
        @Operation(name = "UpdatePersonInfo"      )
    void updatePersonInfo(
    );
        @Operation(name = "UpdatePersonInfo"      )
    void updatePersonInfo(
        @Parameter(name = "person", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.Person", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.Person person
    );
        @Operation(name = "UpdatePersonInfo"      )
    void updatePersonInfo(
        @Parameter(name = "employee", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.Employee", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.Employee employee
    );
        @Operation(name = "UpdatePersonInfo"      )
    void updatePersonInfo(
        @Parameter(name = "specialEmployee", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.SpecialEmployee", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.SpecialEmployee specialEmployee
    );
        @Operation(name = "UpdatePersonInfo"      )
    void updatePersonInfo(
        @Parameter(name = "contractor", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.Contractor", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.Contractor contractor
    );
        @Operation(name = "IncreaseEmployeeSalary"      ,
                    returnType = "Edm.Boolean")
    Boolean increaseEmployeeSalary(
        @Parameter(name = "employee", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.Employee", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.Employee employee, 
        @Parameter(name = "n", type = "Edm.Int32", nullable = false) Integer n
    );
        @Operation(name = "IncreaseEmployeeSalary"      ,
                    returnType = "Edm.Int32")
    Integer increaseEmployeeSalary(
        @Parameter(name = "specialEmployee", type = "Microsoft.Test.OData.Services.AstoriaDefaultService.SpecialEmployee", nullable = true) com.msopentech.odatajclient.proxy.actionoverloadingservice.microsoft.test.odata.services.astoriadefaultservice.types.SpecialEmployee specialEmployee
    );
  }
