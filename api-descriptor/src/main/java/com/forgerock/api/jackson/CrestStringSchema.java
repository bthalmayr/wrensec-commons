/*
 * The contents of this file are subject to the terms of the Common Development and
 * Distribution License (the License). You may not use this file except in compliance with the
 * License.
 *
 * You can obtain a copy of the License at legal/CDDLv1.0.txt. See the License for the
 * specific language governing permission and limitations under the License.
 *
 * When distributing Covered Software, include this CDDL Header Notice in each file and include
 * the License file at legal/CDDLv1.0.txt. If applicable, add the following below the CDDL
 * Header, with the fields enclosed by brackets [] replaced by your own identifying
 * information: "Portions copyright [year] [name of copyright owner]".
 *
 * Copyright 2016 ForgeRock AS.
 */

package com.forgerock.api.jackson;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.module.jsonSchema.types.StringSchema;
import com.forgerock.api.enums.WritePolicy;

/**
 * An extension to the Jackson {@code StringSchema} that includes the custom CREST JSON Schema attributes.
 */
class CrestStringSchema extends StringSchema implements CrestReadWritePoliciesSchema, OrderedFieldSchema, EnumSchema {
    private WritePolicy writePolicy;
    private Boolean errorOnWritePolicyFailure;
    private Integer propertyOrder;
    @JsonProperty
    private Map<String, List<String>> options;

    @Override
    public WritePolicy getWritePolicy() {
        return writePolicy;
    }

    @Override
    public void setWritePolicy(WritePolicy policy) {
        this.writePolicy = policy;
    }

    @Override
    public Boolean getErrorOnWritePolicyFailure() {
        return errorOnWritePolicyFailure;
    }

    @Override
    public void setErrorOnWritePolicyFailure(Boolean errorOnWritePolicyFailure) {
        this.errorOnWritePolicyFailure = errorOnWritePolicyFailure;
    }

    @Override
    public Integer getPropertyOrder() {
        return propertyOrder;
    }

    @Override
    public void setPropertyOrder(Integer order) {
        this.propertyOrder = order;
    }

    @Override
    public List<String> getEnumTitles() {
        return options.get(ENUM_TITLES);
    }

    @Override
    public void setEnumTitles(List<String> titles) {
        this.options = Collections.singletonMap(ENUM_TITLES, titles);
    }
}