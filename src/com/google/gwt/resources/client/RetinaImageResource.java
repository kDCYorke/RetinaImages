package com.google.gwt.resources.client;

import com.google.gwt.resources.ext.DefaultExtensions;
import com.google.gwt.resources.ext.ResourceGeneratorType;
import com.google.gwt.resources.rg.RetinaImageResourceGenerator;

@DefaultExtensions(value = {"@2x.png","@2x.jpg","@2x.gif","@2x.bmp",".png",".jpg",".gif",".bmp"})
@ResourceGeneratorType(RetinaImageResourceGenerator.class)
public interface RetinaImageResource extends ImageResource
  {
  public boolean isRetina();
  }