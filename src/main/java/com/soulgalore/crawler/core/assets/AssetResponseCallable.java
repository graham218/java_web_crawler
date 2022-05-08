/******************************************************
 * Web crawler
 * 
 * 
 * Copyright (C) 2013 by Peter Hedenskog (http://peterhedenskog.com)
 * 
 ****************************************************** 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 ******************************************************* 
 */
package com.soulgalore.crawler.core.assets;

import java.util.Map;
import java.util.concurrent.Callable;

import com.soulgalore.crawler.core.CrawlerURL;

/**
 * 
 * A callable that fetch a HTTP response code and return response to the caller.
 */
public class AssetResponseCallable implements Callable<AssetResponse> {

  private final AssetFetcher getter;
  private final Map<String, String> requestHeaders;
  private final String url;
  private final String referer;
  public AssetResponseCallable(String theUrl, AssetFetcher theGetter,
      Map<String, String> theRequestHeaders, String theReferer) {
    url = theUrl;
    getter = theGetter;
    requestHeaders = theRequestHeaders;
    referer = theReferer;
  }

  public AssetResponse call() throws InterruptedException {
    return getter.getAsset(new CrawlerURL(url,referer), requestHeaders);
  }

  @Override
  public String toString() {
    // TODO add request headers
    return this.getClass().getSimpleName() + " url:" + url;
  }
}
