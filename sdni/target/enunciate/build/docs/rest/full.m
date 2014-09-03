#import "full.h"
#ifndef DEF_FULLNS0NetworkCapabilities_M
#define DEF_FULLNS0NetworkCapabilities_M

/**
 * (no documentation provided)
 */
@implementation FULLNS0NetworkCapabilities

/**
 * (no documentation provided)
 */
- (NSArray *) link
{
  return _link;
}

/**
 * (no documentation provided)
 */
- (void) setLink: (NSArray *) newLink
{
  [newLink retain];
  [_link release];
  _link = newLink;
}

/**
 * (no documentation provided)
 */
- (NSArray *) macAddressList
{
  return _macAddressList;
}

/**
 * (no documentation provided)
 */
- (void) setMacAddressList: (NSArray *) newMacAddressList
{
  [newMacAddressList retain];
  [_macAddressList release];
  _macAddressList = newMacAddressList;
}

/**
 * (no documentation provided)
 */
- (NSArray *) controller
{
  return _controller;
}

/**
 * (no documentation provided)
 */
- (void) setController: (NSArray *) newController
{
  [newController retain];
  [_controller release];
  _controller = newController;
}

/**
 * (no documentation provided)
 */
- (NSArray *) node
{
  return _node;
}

/**
 * (no documentation provided)
 */
- (void) setNode: (NSArray *) newNode
{
  [newNode retain];
  [_node release];
  _node = newNode;
}

/**
 * (no documentation provided)
 */
- (NSArray *) bandwidth
{
  return _bandwidth;
}

/**
 * (no documentation provided)
 */
- (void) setBandwidth: (NSArray *) newBandwidth
{
  [newBandwidth retain];
  [_bandwidth release];
  _bandwidth = newBandwidth;
}

/**
 * (no documentation provided)
 */
- (NSArray *) host
{
  return _host;
}

/**
 * (no documentation provided)
 */
- (void) setHost: (NSArray *) newHost
{
  [newHost retain];
  [_host release];
  _host = newHost;
}

/**
 * (no documentation provided)
 */
- (NSArray *) ipAddressList
{
  return _ipAddressList;
}

/**
 * (no documentation provided)
 */
- (void) setIpAddressList: (NSArray *) newIpAddressList
{
  [newIpAddressList retain];
  [_ipAddressList release];
  _ipAddressList = newIpAddressList;
}

/**
 * (no documentation provided)
 */
- (NSArray *) latency
{
  return _latency;
}

/**
 * (no documentation provided)
 */
- (void) setLatency: (NSArray *) newLatency
{
  [newLatency retain];
  [_latency release];
  _latency = newLatency;
}

- (void) dealloc
{
  [self setLink: nil];
  [self setMacAddressList: nil];
  [self setController: nil];
  [self setNode: nil];
  [self setBandwidth: nil];
  [self setHost: nil];
  [self setIpAddressList: nil];
  [self setLatency: nil];
  [super dealloc];
}

//documentation inherited.
+ (id<EnunciateXML>) readFromXML: (NSData *) xml
{
  FULLNS0NetworkCapabilities *_fULLNS0NetworkCapabilities;
  xmlTextReaderPtr reader = xmlReaderForMemory([xml bytes], [xml length], NULL, NULL, 0);
  if (reader == NULL) {
    [NSException raise: @"XMLReadError"
                 format: @"Error instantiating an XML reader."];
    return nil;
  }

  _fULLNS0NetworkCapabilities = (FULLNS0NetworkCapabilities *) [FULLNS0NetworkCapabilities readXMLElement: reader];
  xmlFreeTextReader(reader); //free the reader
  return _fULLNS0NetworkCapabilities;
}

//documentation inherited.
- (NSData *) writeToXML
{
  xmlBufferPtr buf;
  xmlTextWriterPtr writer;
  int rc;
  NSData *data;

  buf = xmlBufferCreate();
  if (buf == NULL) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML buffer."];
    return nil;
  }

  writer = xmlNewTextWriterMemory(buf, 0);
  if (writer == NULL) {
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error creating an XML writer."];
    return nil;
  }

  rc = xmlTextWriterStartDocument(writer, NULL, "utf-8", NULL);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML start document."];
    return nil;
  }

  NS_DURING
  {
    [self writeXMLElement: writer];
  }
  NS_HANDLER
  {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [localException raise];
  }
  NS_ENDHANDLER

  rc = xmlTextWriterEndDocument(writer);
  if (rc < 0) {
    xmlFreeTextWriter(writer);
    xmlBufferFree(buf);
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing XML end document."];
    return nil;
  }

  xmlFreeTextWriter(writer);
  data = [NSData dataWithBytes: buf->content length: buf->use];
  xmlBufferFree(buf);
  return data;
}
@end /* implementation FULLNS0NetworkCapabilities */

/**
 * Internal, private interface for JAXB reading and writing.
 */
@interface FULLNS0NetworkCapabilities (JAXB) <JAXBReading, JAXBWriting, JAXBType, JAXBElement>

@end /*interface FULLNS0NetworkCapabilities (JAXB)*/

/**
 * Internal, private implementation for JAXB reading and writing.
 */
@implementation FULLNS0NetworkCapabilities (JAXB)

/**
 * Read an instance of FULLNS0NetworkCapabilities from an XML reader.
 *
 * @param reader The reader.
 * @return An instance of FULLNS0NetworkCapabilities defined by the XML reader.
 */
+ (id<JAXBType>) readXMLType: (xmlTextReaderPtr) reader
{
  FULLNS0NetworkCapabilities *_fULLNS0NetworkCapabilities = [[FULLNS0NetworkCapabilities alloc] init];
  NS_DURING
  {
    [_fULLNS0NetworkCapabilities initWithReader: reader];
  }
  NS_HANDLER
  {
    _fULLNS0NetworkCapabilities = nil;
    [localException raise];
  }
  NS_ENDHANDLER

  [_fULLNS0NetworkCapabilities autorelease];
  return _fULLNS0NetworkCapabilities;
}

/**
 * Initialize this instance of FULLNS0NetworkCapabilities according to
 * the XML being read from the reader.
 *
 * @param reader The reader.
 */
- (id) initWithReader: (xmlTextReaderPtr) reader
{
  return [super initWithReader: reader];
}

/**
 * Write the XML for this instance of FULLNS0NetworkCapabilities to the writer.
 * Note that since we're only writing the XML type,
 * No start/end element will be written.
 *
 * @param reader The reader.
 */
- (void) writeXMLType: (xmlTextWriterPtr) writer
{
  [super writeXMLType:writer];
}

/**
 * Reads a FULLNS0NetworkCapabilities from an XML reader. The element to be read is
 * "networkCapabilities".
 *
 * @param reader The XML reader.
 * @return The FULLNS0NetworkCapabilities.
 */
+ (id<JAXBElement>) readXMLElement: (xmlTextReaderPtr) reader {
  int status;
  FULLNS0NetworkCapabilities *_networkCapabilities = nil;

  if (xmlTextReaderNodeType(reader) != XML_READER_TYPE_ELEMENT) {
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
    if (status < 1) {
      [NSException raise: @"XMLReadError"
                   format: @"Error advancing the reader to start element networkCapabilities."];
    }
  }

  if (xmlStrcmp(BAD_CAST "networkCapabilities", xmlTextReaderConstLocalName(reader)) == 0
      && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read root element {}networkCapabilities.");
#endif
    _networkCapabilities = (FULLNS0NetworkCapabilities *)[FULLNS0NetworkCapabilities readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"Successfully read root element {}networkCapabilities.");
#endif
  }
  else {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read FULLNS0NetworkCapabilities. Expected element networkCapabilities. Current element: {}%s", xmlTextReaderConstLocalName(reader)];
    }
    else {
      [NSException raise: @"XMLReadError"
                   format: @"Unable to read FULLNS0NetworkCapabilities. Expected element networkCapabilities. Current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader)];
    }
  }

  return _networkCapabilities;
}

/**
 * Writes this FULLNS0NetworkCapabilities to XML under element name "networkCapabilities".
 * The namespace declarations for the element will be written.
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return 1 if successful, 0 otherwise.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer
{
  [self writeXMLElement: writer writeNamespaces: YES];
}

/**
 * Writes this FULLNS0NetworkCapabilities to an XML writer.
 *
 * @param writer The writer.
 * @param writeNs Whether to write the namespaces for this element to the xml writer.
 */
- (void) writeXMLElement: (xmlTextWriterPtr) writer writeNamespaces: (BOOL) writeNs
{
  int rc = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "networkCapabilities", NULL);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing start element {}networkCapabilities. XML writer status: %i\n", rc];
  }

#if DEBUG_ENUNCIATE > 1
  NSLog(@"writing type {}networkCapabilities for root element {}networkCapabilities...");
#endif
  [self writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
  NSLog(@"successfully wrote type {}networkCapabilities for root element {}networkCapabilities...");
#endif
  rc = xmlTextWriterEndElement(writer);
  if (rc < 0) {
    [NSException raise: @"XMLWriteError"
                 format: @"Error writing end element {}networkCapabilities. XML writer status: %i\n", rc];
  }
}

//documentation inherited.
- (BOOL) readJAXBAttribute: (xmlTextReaderPtr) reader
{
  void *_child_accessor;

  if ([super readJAXBAttribute: reader]) {
    return YES;
  }

  return NO;
}

//documentation inherited.
- (BOOL) readJAXBValue: (xmlTextReaderPtr) reader
{
  return [super readJAXBValue: reader];
}

//documentation inherited.
- (BOOL) readJAXBChildElement: (xmlTextReaderPtr) reader
{
  id __child;
  void *_child_accessor;
  int status, depth;

  if ([super readJAXBChildElement: reader]) {
    return YES;
  }
  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "link", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}link of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}link of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self link]) {
      [self setLink: [[self link] arrayByAddingObject: __child]];
    }
    else {
      [self setLink: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "macAddressList", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}macAddressList of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}macAddressList of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self macAddressList]) {
      [self setMacAddressList: [[self macAddressList] arrayByAddingObject: __child]];
    }
    else {
      [self setMacAddressList: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "controller", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}controller of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}controller of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self controller]) {
      [self setController: [[self controller] arrayByAddingObject: __child]];
    }
    else {
      [self setController: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "node", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}node of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}node of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self node]) {
      [self setNode: [[self node] arrayByAddingObject: __child]];
    }
    else {
      [self setNode: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "bandwidth", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}bandwidth of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}bandwidth of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self bandwidth]) {
      [self setBandwidth: [[self bandwidth] arrayByAddingObject: __child]];
    }
    else {
      [self setBandwidth: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "host", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}host of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}host of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self host]) {
      [self setHost: [[self host] arrayByAddingObject: __child]];
    }
    else {
      [self setHost: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "ipAddressList", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}ipAddressList of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}ipAddressList of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self ipAddressList]) {
      [self setIpAddressList: [[self ipAddressList] arrayByAddingObject: __child]];
    }
    else {
      [self setIpAddressList: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "latency", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
    NSLog(@"Attempting to read choice {}latency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

     __child = [NSString readXMLType: reader];
#if DEBUG_ENUNCIATE > 1
    NSLog(@"successfully read choice {}latency of type {http://www.w3.org/2001/XMLSchema}string.");
#endif

    if ([self latency]) {
      [self setLatency: [[self latency] arrayByAddingObject: __child]];
    }
    else {
      [self setLatency: [NSArray arrayWithObject: __child]];
    }
    return YES;
  } //end "if choice"


  return NO;
}

//documentation inherited.
- (int) readUnknownJAXBChildElement: (xmlTextReaderPtr) reader
{
  return [super readUnknownJAXBChildElement: reader];
}

//documentation inherited.
- (void) readUnknownJAXBAttribute: (xmlTextReaderPtr) reader
{
  [super readUnknownJAXBAttribute: reader];
}

//documentation inherited.
- (void) writeJAXBAttributes: (xmlTextWriterPtr) writer
{
  int status;

  [super writeJAXBAttributes: writer];

}

//documentation inherited.
- (void) writeJAXBValue: (xmlTextWriterPtr) writer
{
  [super writeJAXBValue: writer];
}

/**
 * Method for writing the child elements.
 *
 * @param writer The writer.
 */
- (void) writeJAXBChildElements: (xmlTextWriterPtr) writer
{
  int status;
  id __item;
  id __item_copy;
  NSEnumerator *__enumerator;

  [super writeJAXBChildElements: writer];

  if ([self link]) {
    __enumerator = [[self link] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "link", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}link."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}link...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}link...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}link."];
      }
    } //end item iterator.
  }
  if ([self macAddressList]) {
    __enumerator = [[self macAddressList] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "macAddressList", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}macAddressList."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}macAddressList...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}macAddressList...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}macAddressList."];
      }
    } //end item iterator.
  }
  if ([self controller]) {
    __enumerator = [[self controller] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "controller", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}controller."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}controller...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}controller...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}controller."];
      }
    } //end item iterator.
  }
  if ([self node]) {
    __enumerator = [[self node] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "node", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}node."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}node...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}node...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}node."];
      }
    } //end item iterator.
  }
  if ([self bandwidth]) {
    __enumerator = [[self bandwidth] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "bandwidth", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}bandwidth."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}bandwidth...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}bandwidth...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}bandwidth."];
      }
    } //end item iterator.
  }
  if ([self host]) {
    __enumerator = [[self host] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "host", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}host."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}host...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}host...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}host."];
      }
    } //end item iterator.
  }
  if ([self ipAddressList]) {
    __enumerator = [[self ipAddressList] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "ipAddressList", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}ipAddressList."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}ipAddressList...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}ipAddressList...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}ipAddressList."];
      }
    } //end item iterator.
  }
  if ([self latency]) {
    __enumerator = [[self latency] objectEnumerator];

    while ( (__item = [__enumerator nextObject]) ) {
      status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "latency", NULL);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing start child element {}latency."];
      }

#if DEBUG_ENUNCIATE > 1
      NSLog(@"writing element {}latency...");
#endif
      [__item writeXMLType: writer];
#if DEBUG_ENUNCIATE > 1
      NSLog(@"successfully wrote element {}latency...");
#endif

      status = xmlTextWriterEndElement(writer);
      if (status < 0) {
        [NSException raise: @"XMLWriteError"
                     format: @"Error writing end child element {}latency."];
      }
    } //end item iterator.
  }
}
@end /* implementation FULLNS0NetworkCapabilities (JAXB) */

#endif /* DEF_FULLNS0NetworkCapabilities_M */
