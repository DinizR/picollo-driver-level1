/*
 * ResourceProcessor.java
 */

package org.picollo.service.rest;

import org.picollo.config.service.OSGiConfig;
import org.picollo.resource.ResourceSupplierInterface;
import org.picollo.resource.exception.BadRequestException;
import org.picollo.resource.exception.GeneralException;
import org.picollo.resource.exception.NotImplementedException;
import org.picollo.resource.model.PicolloHttpRequest;
import org.picollo.resource.utils.RestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping("/picollo/api")
/**
 * Entry point for resource interaction
 * @author rod
 * @since 2019-03-25
 */
public class ResourceProcessor {
   private static final Logger log = LoggerFactory.getLogger(ResourceProcessor.class);

   @GetMapping("/{driverName}")
   public ResponseEntity<Object> handleGetAllResource(final HttpServletRequest request,
                                                      final @PathVariable String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("GET ALL Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handleGetAll(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The GET ALL method is not implemented for " + driverName + ".");
         }
         log.debug("GET ALL Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process GET ALL on " + request.getRequestURI() + " not found.");
      }
   }

   @PostMapping("/{driverName}")
   public ResponseEntity<Object> handlePostResource(final HttpServletRequest request,
                                                    @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("POST Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handlePost(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The POST method is not implemented for " + driverName + ".");
         }
         log.debug("POST Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process POST on " + request.getRequestURI() + " not found.");
      }
   }

   @GetMapping("/{driverName}/{id}")
   public ResponseEntity<Object> handleGetOneResource(final HttpServletRequest request,
                                                      @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("GET Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handleGetOne(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The GET ONE method is not implemented for " + driverName + ".");
         }
         log.debug("GET Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process GET ONE on " + request.getRequestURI() + " not found.");
      }
   }

   @GetMapping("/{driverName}/{id}/{relatedEntity}")
   public ResponseEntity<Object> handleGetAllRelatedResource(final HttpServletRequest request,
                                                             @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("GET RELATED Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handleGetAllRelated(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The GET ALL RELATED method is not implemented for " + driverName + ".");
         }
         log.debug("GET RELATED Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process GET ALL RELATED on " + request.getRequestURI() + " not found.");
      }
   }

   @GetMapping("/{driverName}/{id}/{relatedEntity}/{relatedId}")
   public ResponseEntity<Object> handleGetOneRelatedResource(final HttpServletRequest request,
                                                             @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("GET ONE RELATED Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handleGetOneRelated(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The GET ONE RELATED method is not implemented for " + driverName + ".");
         }
         log.debug("GET RELATED Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process GET ONE RELATED on " + request.getRequestURI() + " not found.");
      }
   }

   @DeleteMapping("/{driverName}")
   public ResponseEntity<Object> handleDeleteResource(final HttpServletRequest request, @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("DELETE Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handleDelete(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The DELETE method is not implemented for " + driverName + ".");
         }
         log.debug("DELETE Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process DELETE on " + request.getRequestURI() + " not found.");
      }
   }

   @PutMapping("/{driverName}")
   public ResponseEntity<Object> handlePutResource(final HttpServletRequest request, @PathVariable final String driverName) {
      final Optional<ResourceSupplierInterface> driver = getDriver(driverName);
      final PicolloHttpRequest picolloHttpRequest = PicolloHttpRequest.builder()
               .pathParams(RestUtils.fetchPathParams(request))
               .cookies(RestUtils.fetchCookies(request))
               .headers(RestUtils.fetchHeaders(request))
               .urlParams(RestUtils.fetchUrlParams(request))
            .build();
      final ResponseEntity<Object> ret;

      log.debug("PUT Resource for driver={} has started with PicolloHttpRequest={}", driverName, picolloHttpRequest);
      if (driver.isPresent()) {
         ret = driver.get().handlePut(picolloHttpRequest);
         if (ret == null) {
            throw new NotImplementedException("The PUT method is not implemented for " + driverName + ".");
         }
         log.debug("PUT Resource for driver={} has finished with Return={}", driverName, ret);
         return ret;
      } else {
         throw new BadRequestException("Driver to process PUT on " + request.getRequestURI() + " not found.");
      }
   }

   private Optional<ResourceSupplierInterface> getDriver(final String driverName) {
      Optional<ResourceSupplierInterface> driver;

      try {
         driver = OSGiConfig.<Optional<ResourceSupplierInterface>, ResourceSupplierInterface>getDriver(ResourceSupplierInterface.class, driverName);
      } catch (SecurityException e) {
         log.error("Incoming request failed verification {}", HttpServletResponse.SC_BAD_REQUEST, e);
         throw new BadRequestException(e.getMessage());
      } catch (Throwable e) {
         String message = String.format("Error processing interceptor for driver = %s.", driverName);
         log.error(message, e);
         throw new GeneralException(message);
      }

      return driver;
   }
}
