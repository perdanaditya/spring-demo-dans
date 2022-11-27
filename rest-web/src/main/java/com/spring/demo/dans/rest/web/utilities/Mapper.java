package com.spring.demo.dans.rest.web.utilities;

import org.mapstruct.factory.Mappers;

/**
 * @author Rizky Perdana
 */
public class Mapper {

  public static final BeanMapper BEAN_MAPPER = Mappers.getMapper(BeanMapper.class);

  private Mapper() {
  }
}