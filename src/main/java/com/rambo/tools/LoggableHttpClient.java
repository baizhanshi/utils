package com.rambo.tools;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/5/14 11:35
 */
public class LoggableHttpClient implements HttpClient {

    private HttpClient httpClient = HttpClients.createDefault();

    @Override
    public HttpParams getParams() {
        return this.httpClient.getParams();
    }

    @Override
    public ClientConnectionManager getConnectionManager() {
        return this.httpClient.getConnectionManager();
    }

    @Override
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        return this.httpClient.execute(request);
    }

    @Override
    public HttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        return this.httpClient.execute(request, context);
    }

    @Override
    public HttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        return this.httpClient.execute(target, request);
    }

    @Override
    public HttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException {
        return this.httpClient.execute(target, request, context);
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        long startTimeMillis = System.currentTimeMillis();
        try {
            return this.httpClient.execute(request, responseHandler);
        } catch (Exception e) {
            throw e;
        } finally {
        }
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context)
            throws IOException {
        return this.httpClient.execute(request, responseHandler, context);
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler)
            throws IOException {
        return this.httpClient.execute(target, request, responseHandler);
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler,
                         HttpContext context)
            throws IOException {
        return this.httpClient.execute(target, request, responseHandler, context);
    }
}