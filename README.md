See http://retina.teknonsys.com for more infomration.

##Using the module

The module can be downloaded here: [RetinaImages.jar](http://retina.teknonsys.com/RetinaImages.jar). To use it, first inherit the module in your `.gwt.xml` file:

```xml 
  <inherits name="com.teknonsys.RetinaImages"/>
```

Images that may have a retina version should use `RetinaImageResource` instead of `ImageResource` in your resource bundles. Because we only want the retina images in the retina permutation, we need to use deferred binding.

In order to use the deferred binding, we effectively have to have two bundles, one with retina images and one without. Note that the retina bundle must extend the normal bundle. Here's a sample bundle:

```java
  public interface DemoClientBundle extends ClientBundle
    {
    ImageResource screenshot();
    ImageResource cube();

    public interface Retina extends DemoClientBundle
      {
      RetinaImageResource screenshot();
      RetinaImageResource cube();
      }
    }
```

We then need a separate factory for each bundle. One for the normal images:

```java
  public class ClientBundleFactory
    {
    public DemoClientBundle create()
      {return GWT.create(DemoClientBundle.class);}
    }
```

And one for retina images:

```java
  public class RetinaClientBundleFactory extends ClientBundleFactory
    {
    public @Override DemoClientBundle create()
      {return GWT.create(DemoClientBundle.Retina.class);}
    }
```

We can now tell the compiler to load the retina bundle only on retina displays:


```xml
  <replace-with class="com.teknonsys.client.RetinaClientBundleFactory">
    <when-type-is class="com.teknonsys.client.ClientBundleFactory"/>
    <when-property-is name="display.type" value="retina"/>
  </replace-with>
```

Notice the `display.type` property. This is set automatically by the module according to the `window.devicePixelRatio` JavaScript property.

Any images that may have retina versions can now be added to the Retina bundle. Retina enhancements will still only be used if an `@2x` image is found.
