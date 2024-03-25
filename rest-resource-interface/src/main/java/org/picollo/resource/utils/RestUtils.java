package org.picollo.resource.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class RestUtils {

   public static Map<String, List<String>> fetchHeaders(final HttpServletRequest request) {
      return Collections.list(request.getHeaderNames())
         .stream()
         .collect(Collectors.toMap(Function.identity(),
            h -> Collections.list(request.getHeaders(h))));
   }

   public static Map<String,String> fetchCookies(final HttpServletRequest request) {
      return request.getCookies() == null ?
            new HashMap<>() :
         Arrays.stream(request.getCookies())
            .collect(Collectors.toMap(Cookie::getName,Cookie::getValue));
   }

   public static Map<String,String[]> fetchUrlParams(final HttpServletRequest request) {
      return request.getParameterMap();
   }

   public static Map<Integer, String> fetchPathParams(final HttpServletRequest request) {
      final int[] next = {1};
      return  Arrays.stream(request.getRequestURI().split("/"))
         .filter(s -> ! s.isEmpty())
         .map(i -> {
            final String[] v = new String[2];
            v[0] = String.valueOf(next[0]++);
            v[1] = i;
            return v;
         })
         .collect(Collectors.toMap(k -> Integer.valueOf(k[0]), v -> v[1]));
   }
}
