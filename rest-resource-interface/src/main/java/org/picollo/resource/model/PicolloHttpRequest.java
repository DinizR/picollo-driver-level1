/*
* PicolloHttpRequest
 */
package org.picollo.resource.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
@ToString
/**
 * Wrapper class for HTTP Request.
 * @author rod
 * @since 2021-09
 */
public class PicolloHttpRequest {
   private Map<String,List<String>> headers;
   private Map<String,String> cookies;
   private Map<String,String[]> urlParams;
   private Map<Integer,String> pathParams;
}