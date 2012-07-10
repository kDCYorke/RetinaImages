package com.google.gwt.user.client.ui.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safecss.shared.SafeStylesUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeUri;

public class ClippedImageImplRetina extends ClippedImageImpl
  {
  private static Template template;
  
  public @Override void adjust(Element img,SafeUri url,int left,int top,
    int width,int height)
    {
    super.adjust(img,url,left,top,width,height);
    img.getStyle().setProperty("backgroundSize",width+"px "+height+"px");
    }
  
  public SafeHtml getSafeHtml(SafeUri url,int left,int top,int width,int height)
    {
    String style = "width: " + width + "px; height: " + height + "px; background: url("
        + url.asString() + ") " + "no-repeat " + (-left + "px ")
        + (-top + "px;") + "background-size: "+ width + "px " + height + "px;";

    return getTemplate().image(clearImage, SafeStylesUtils.fromTrustedString(style));
    }

  private Template getTemplate()
    {
    if (template == null)
      template = GWT.create(Template.class);
    return template;
    }
  }