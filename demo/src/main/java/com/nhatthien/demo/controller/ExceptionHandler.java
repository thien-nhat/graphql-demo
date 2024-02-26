package com.nhatthien.demo.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Conponent
public class ExceptionHandler extends DataFetcherExceptionResolverAdapter{

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        // TODO Auto-generated method stub
        ErrorType type = null;
        if (ex instanceof DataIntegrityViolationException ) {
            type = ErrorType.BAD_REQUEST;
        } else {
            type = ErrorType.INTERNAL_ERROR;
        }
        // return super.resolveToSingleError(ex, env);
        return GraphqlErrorBuilder.newError(env)
        .message("Receive Message" + ex.getMessage())
        .errorType(type)
        .build();
    }
    
}
