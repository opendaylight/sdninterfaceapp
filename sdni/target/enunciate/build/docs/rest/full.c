#include <enunciate-common.c>
#ifndef DEF_full_ns0_networkCapabilities_H
#define DEF_full_ns0_networkCapabilities_H

/**
 * (no documentation provided)
 */
struct full_ns0_networkCapabilities {


  /**
   * (no documentation provided)
   */
  xmlChar *link;

  /**
   * Size of the link array.
   */
  int _sizeof_link;

  /**
   * (no documentation provided)
   */
  xmlChar *macAddressList;

  /**
   * Size of the macAddressList array.
   */
  int _sizeof_macAddressList;

  /**
   * (no documentation provided)
   */
  xmlChar *controller;

  /**
   * Size of the controller array.
   */
  int _sizeof_controller;

  /**
   * (no documentation provided)
   */
  xmlChar *node;

  /**
   * Size of the node array.
   */
  int _sizeof_node;

  /**
   * (no documentation provided)
   */
  xmlChar *bandwidth;

  /**
   * Size of the bandwidth array.
   */
  int _sizeof_bandwidth;

  /**
   * (no documentation provided)
   */
  xmlChar *host;

  /**
   * Size of the host array.
   */
  int _sizeof_host;

  /**
   * (no documentation provided)
   */
  xmlChar *ipAddressList;

  /**
   * Size of the ipAddressList array.
   */
  int _sizeof_ipAddressList;

  /**
   * (no documentation provided)
   */
  xmlChar *latency;

  /**
   * Size of the latency array.
   */
  int _sizeof_latency;
};

/**
 * Reads a NetworkCapabilities element from XML. The element to be read is "networkCapabilities", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The NetworkCapabilities, or NULL in case of error.
 */
struct full_ns0_networkCapabilities *xml_read_full_ns0_networkCapabilities(xmlTextReaderPtr reader);

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
int xml_write_full_ns0_networkCapabilities(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities);

/**
 * Frees a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities to free.
 */
void free_full_ns0_networkCapabilities(struct full_ns0_networkCapabilities *_networkCapabilities);

/**
 * Reads a NetworkCapabilities element from XML. The element to be read is "networkCapabilities", and
 * it is assumed that the reader is already pointing to the element.
 *
 * @param reader The XML reader.
 * @return The NetworkCapabilities, or NULL in case of error.
 */
struct full_ns0_networkCapabilities *xmlTextReaderReadNs0NetworkCapabilitiesElement(xmlTextReaderPtr reader);

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesElement(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities);

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesElementNS(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities, int writeNamespaces);

/**
 * Frees the children of a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities whose children are to be free.
 */
static void freeNs0NetworkCapabilitiesElement(struct full_ns0_networkCapabilities *_networkCapabilities);

/**
 * Reads a NetworkCapabilities from XML. The reader is assumed to be at the start element.
 *
 * @param reader The XML reader.
 * @return The NetworkCapabilities, or NULL in case of error.
 */
static struct full_ns0_networkCapabilities *xmlTextReaderReadNs0NetworkCapabilitiesType(xmlTextReaderPtr reader);

/**
 * Writes a NetworkCapabilities to XML.
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return The bytes written (may be 0 in case of buffering) or -1 in case of error.
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesType(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities);

/**
 * Frees the elements of a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities to free.
 */
static void freeNs0NetworkCapabilitiesType(struct full_ns0_networkCapabilities *_networkCapabilities);

#endif /* DEF_full_ns0_networkCapabilities_H */
#ifndef DEF_full_ns0_networkCapabilities_M
#define DEF_full_ns0_networkCapabilities_M

/**
 * Reads a NetworkCapabilities element from XML. The element to be read is "networkCapabilities", and
 * it is assumed that the reader is pointing to the XML document (not the element).
 *
 * @param reader The XML reader.
 * @return The NetworkCapabilities, or NULL in case of error.
 */
struct full_ns0_networkCapabilities *xml_read_full_ns0_networkCapabilities(xmlTextReaderPtr reader) {
  int status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
  return xmlTextReaderReadNs0NetworkCapabilitiesElement(reader);
}

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return 1 if successful, 0 otherwise.
 */
int xml_write_full_ns0_networkCapabilities(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities) {
  return xmlTextWriterWriteNs0NetworkCapabilitiesElementNS(writer, _networkCapabilities, 1);
}

/**
 * Frees a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities to free.
 */
void free_full_ns0_networkCapabilities(struct full_ns0_networkCapabilities *_networkCapabilities) {
  freeNs0NetworkCapabilitiesType(_networkCapabilities);
  free(_networkCapabilities);
}

/**
 * Reads a NetworkCapabilities element from XML. The element to be read is "networkCapabilities", and
 * it is assumed that the reader is pointing to that element.
 *
 * @param reader The XML reader.
 * @return The NetworkCapabilities, or NULL in case of error.
 */
struct full_ns0_networkCapabilities *xmlTextReaderReadNs0NetworkCapabilitiesElement(xmlTextReaderPtr reader) {
  struct full_ns0_networkCapabilities *_networkCapabilities = NULL;

  if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
    && xmlStrcmp(BAD_CAST "networkCapabilities", xmlTextReaderConstLocalName(reader)) == 0
    && xmlTextReaderConstNamespaceUri(reader) == NULL) {
#if DEBUG_ENUNCIATE > 1
    printf("Attempting to read root element {}networkCapabilities.\n");
#endif
    _networkCapabilities = xmlTextReaderReadNs0NetworkCapabilitiesType(reader);
  }
#if DEBUG_ENUNCIATE
  if (_networkCapabilities == NULL) {
    if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
      printf("attempt to read {}networkCapabilities failed. current element: {}%s\n",  xmlTextReaderConstLocalName(reader));
    }
    else {
      printf("attempt to read {}networkCapabilities failed. current element: {%s}%s\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
    }
  }
#endif

  return _networkCapabilities;
}

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 * Does NOT write the namespace prefixes.
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesElement(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities) {
  return xmlTextWriterWriteNs0NetworkCapabilitiesElementNS(writer, _networkCapabilities, 0);
}

/**
 * Writes a NetworkCapabilities to XML under element name "networkCapabilities".
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @param writeNamespaces Whether to write the namespace prefixes.
 * @return 1 if successful, 0 otherwise.
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesElementNS(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities, int writeNamespaces) {
  int totalBytes = 0;
  int status;

  status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "networkCapabilities", NULL);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write start element {}networkCapabilities. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

#if DEBUG_ENUNCIATE > 1
  printf("writing type {}networkCapabilities for root element {}networkCapabilities...\n");
#endif
  status = xmlTextWriterWriteNs0NetworkCapabilitiesType(writer, _networkCapabilities);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to write type for start element {}networkCapabilities. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  status = xmlTextWriterEndElement(writer);
  if (status < 0) {
#if DEBUG_ENUNCIATE
    printf("unable to end element {}networkCapabilities. status: %i\n", status);
#endif
    return status;
  }
  totalBytes += status;

  return totalBytes;
}

/**
 * Frees the children of a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities whose children are to be free.
 */
static void freeNs0NetworkCapabilitiesElement(struct full_ns0_networkCapabilities *_networkCapabilities) {
  freeNs0NetworkCapabilitiesType(_networkCapabilities);
}

/**
 * Reads a NetworkCapabilities from XML. The reader is assumed to be at the start element.
 *
 * @return the NetworkCapabilities, or NULL in case of error.
 */
static struct full_ns0_networkCapabilities *xmlTextReaderReadNs0NetworkCapabilitiesType(xmlTextReaderPtr reader) {
  int status, depth;
  void *_child_accessor;
  struct full_ns0_networkCapabilities *_networkCapabilities = calloc(1, sizeof(struct full_ns0_networkCapabilities));



  if (xmlTextReaderIsEmptyElement(reader) == 0) {
    depth = xmlTextReaderDepth(reader);//track the depth.
    status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);

    while (xmlTextReaderDepth(reader) > depth) {
      if (status < 1) {
        //panic: XML read error.
#if DEBUG_ENUNCIATE
        printf("Failure to advance to next child element.\n");
#endif
        freeNs0NetworkCapabilitiesType(_networkCapabilities);
        free(_networkCapabilities);
        return NULL;
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "link", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}link of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}link of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->link = realloc(_networkCapabilities->link, (_networkCapabilities->_sizeof_link + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->link[_networkCapabilities->_sizeof_link++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "macAddressList", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}macAddressList of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}macAddressList of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->macAddressList = realloc(_networkCapabilities->macAddressList, (_networkCapabilities->_sizeof_macAddressList + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->macAddressList[_networkCapabilities->_sizeof_macAddressList++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "controller", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}controller of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}controller of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->controller = realloc(_networkCapabilities->controller, (_networkCapabilities->_sizeof_controller + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->controller[_networkCapabilities->_sizeof_controller++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "node", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}node of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}node of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->node = realloc(_networkCapabilities->node, (_networkCapabilities->_sizeof_node + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->node[_networkCapabilities->_sizeof_node++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "bandwidth", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}bandwidth of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}bandwidth of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->bandwidth = realloc(_networkCapabilities->bandwidth, (_networkCapabilities->_sizeof_bandwidth + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->bandwidth[_networkCapabilities->_sizeof_bandwidth++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "host", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}host of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}host of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->host = realloc(_networkCapabilities->host, (_networkCapabilities->_sizeof_host + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->host[_networkCapabilities->_sizeof_host++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "ipAddressList", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}ipAddressList of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}ipAddressList of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->ipAddressList = realloc(_networkCapabilities->ipAddressList, (_networkCapabilities->_sizeof_ipAddressList + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->ipAddressList[_networkCapabilities->_sizeof_ipAddressList++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else if (xmlTextReaderNodeType(reader) == XML_READER_TYPE_ELEMENT
        && xmlStrcmp(BAD_CAST "latency", xmlTextReaderConstLocalName(reader)) == 0
        && xmlTextReaderConstNamespaceUri(reader) == NULL) {

#if DEBUG_ENUNCIATE > 1
        printf("Attempting to read choice {}latency of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
        _child_accessor = xmlTextReaderReadXsStringType(reader);
        if (_child_accessor == NULL) {
#if DEBUG_ENUNCIATE
          printf("Failed to read choice {}latency of type {http://www.w3.org/2001/XMLSchema}string.\n");
#endif
          //panic: unable to read the child element for some reason.
          freeNs0NetworkCapabilitiesType(_networkCapabilities);
          free(_networkCapabilities);
          return NULL;
        }

        _networkCapabilities->latency = realloc(_networkCapabilities->latency, (_networkCapabilities->_sizeof_latency + 1) * sizeof(xmlChar));
        memcpy(&(_networkCapabilities->latency[_networkCapabilities->_sizeof_latency++]), _child_accessor, sizeof(xmlChar));
        free(_child_accessor);
        status = xmlTextReaderAdvanceToNextStartOrEndElement(reader);
      }
      else {
#if DEBUG_ENUNCIATE > 1
        if (xmlTextReaderConstNamespaceUri(reader) == NULL) {
          printf("unknown child element {}%s for type {}networkCapabilities.  Skipping...\n",  xmlTextReaderConstLocalName(reader));
        }
        else {
          printf("unknown child element {%s}%s for type {}networkCapabilities. Skipping...\n", xmlTextReaderConstNamespaceUri(reader), xmlTextReaderConstLocalName(reader));
        }
#endif
        status = xmlTextReaderSkipElement(reader);
      }
    }
  }

  return _networkCapabilities;
}

/**
 * Writes a NetworkCapabilities to XML.
 *
 * @param writer The XML writer.
 * @param _networkCapabilities The NetworkCapabilities to write.
 * @return The total bytes written, or -1 on error;
 */
static int xmlTextWriterWriteNs0NetworkCapabilitiesType(xmlTextWriterPtr writer, struct full_ns0_networkCapabilities *_networkCapabilities) {
  int status, totalBytes = 0, i;
  xmlChar *binaryData;
  for (i = 0; i < _networkCapabilities->_sizeof_link; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "link", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}link. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}link...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->link[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}link. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}link. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_macAddressList; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "macAddressList", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}macAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}macAddressList...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->macAddressList[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}macAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}macAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_controller; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "controller", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}controller. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}controller...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->controller[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}controller. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}controller. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_node; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "node", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}node. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}node...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->node[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}node. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}node. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_bandwidth; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "bandwidth", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}bandwidth. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}bandwidth...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->bandwidth[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}bandwidth. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}bandwidth. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_host; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "host", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}host. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}host...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->host[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}host. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}host. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_ipAddressList; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "ipAddressList", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}ipAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}ipAddressList...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->ipAddressList[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}ipAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}ipAddressList. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }
  for (i = 0; i < _networkCapabilities->_sizeof_latency; i++) {
    status = xmlTextWriterStartElementNS(writer, NULL, BAD_CAST "latency", NULL);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write start element {}latency. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
#if DEBUG_ENUNCIATE > 1
    printf("writing type {http://www.w3.org/2001/XMLSchema}string for element {}latency...\n");
#endif
    status = xmlTextWriterWriteXsStringType(writer, &(_networkCapabilities->latency[i]));
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write type {http://www.w3.org/2001/XMLSchema}string for element {}latency. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;

    status = xmlTextWriterEndElement(writer);
    if (status < 0) {
#if DEBUG_ENUNCIATE
      printf("Failed to write end element {}latency. status: %i\n", status);
#endif
      return status;
    }
    totalBytes += status;
  }

  return totalBytes;
}

/**
 * Frees the elements of a NetworkCapabilities.
 *
 * @param _networkCapabilities The NetworkCapabilities to free.
 */
static void freeNs0NetworkCapabilitiesType(struct full_ns0_networkCapabilities *_networkCapabilities) {
  int i;
  if (_networkCapabilities->link != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_link; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor link[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->link[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor link of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->link);
  }
  if (_networkCapabilities->macAddressList != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_macAddressList; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor macAddressList[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->macAddressList[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor macAddressList of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->macAddressList);
  }
  if (_networkCapabilities->controller != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_controller; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor controller[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->controller[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor controller of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->controller);
  }
  if (_networkCapabilities->node != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_node; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor node[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->node[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor node of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->node);
  }
  if (_networkCapabilities->bandwidth != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_bandwidth; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor bandwidth[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->bandwidth[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor bandwidth of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->bandwidth);
  }
  if (_networkCapabilities->host != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_host; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor host[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->host[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor host of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->host);
  }
  if (_networkCapabilities->ipAddressList != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_ipAddressList; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor ipAddressList[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->ipAddressList[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor ipAddressList of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->ipAddressList);
  }
  if (_networkCapabilities->latency != NULL) {
    for (i = 0; i < _networkCapabilities->_sizeof_latency; i++) {
#if DEBUG_ENUNCIATE > 1
      printf("Freeing accessor latency[%i] of type full_ns0_networkCapabilities...\n", i);
#endif
      freeXsStringType(&(_networkCapabilities->latency[i]));
    }
#if DEBUG_ENUNCIATE > 1
    printf("Freeing accessor latency of type full_ns0_networkCapabilities...\n");
#endif
    free(_networkCapabilities->latency);
  }
}
#endif /* DEF_full_ns0_networkCapabilities_M */
