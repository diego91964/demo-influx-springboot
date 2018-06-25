package br.uaijug.service.metrics.restclient;

import br.uaijug.service.metrics.exceptions.EHttpError;
import br.uaijug.service.metrics.exceptions.EJsonBad;

/**
 * Created by ups on 17/12/17.
 */
public interface IRestClient {

    public <T> T get(String uri, Class<T> responseType) throws EJsonBad, EHttpError;

}
