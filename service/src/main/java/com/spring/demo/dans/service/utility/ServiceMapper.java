package com.spring.demo.dans.service.utility;

import org.mapstruct.factory.Mappers;

/**
 * @author Rizky Perdana
 */
public class ServiceMapper {

  public static final ServiceBeanMapper BEAN_MAPPER = Mappers.getMapper(ServiceBeanMapper.class);

  private ServiceMapper() {
  }
}