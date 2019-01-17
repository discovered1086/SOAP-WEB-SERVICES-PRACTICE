package com.kingshuk.webservices.errorresponses;

@FunctionalInterface
public interface GenericErrorResponseCreator<T extends PreEndpointErrorResponses> {
	
	public T getErrorResponse();

}
