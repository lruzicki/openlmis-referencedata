package org.openlmis.referencedata.util;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

public class MessageTest {

  @Test(expected = NullPointerException.class)
  public void messageShouldRequireNonNullKey() {
    Message msg = new Message(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void messageShouldRequireNonEmptyKey() {
    Message msg = new Message(" ");
  }

  @Test(expected = NoSuchMessageException.class)
  public void humanStringShouldThrowExceptionIfKeyNotFound() {
    MessageSource messageSource = Mockito.mock(MessageSource.class);
    Locale locale = Locale.getDefault();

    String key = "foo.bar";
    String p1 = "some";
    String p2 = "stuff";
    Message msg = new Message("foo.bar", "some", "stuff");

    Mockito.when(messageSource.getMessage(key, new Object[]{p1, p2}, locale))
        .thenThrow(NoSuchMessageException.class);
    msg.localMessage(messageSource, locale);
  }

  @Test
  public void equalsAndHashCodeShouldUseKey() {
    Message foo1 = new Message("foo");
    Message foo2 = new Message("foo");
    assert foo1.equals(foo2);
    assert foo2.equals(foo1);
    assert foo1.hashCode() == foo2.hashCode();
  }

  @Test
  public void equalsAndHashCodeShouldIgnoreSpaceAndCase() {
    Message foo1 = new Message("foo" );
    Message foo2 = new Message(" Foo " );
    assert foo1.equals(foo2);
    assert foo2.equals(foo1);
    assert foo1.hashCode() == foo2.hashCode();
  }
}