#import "enunciate-common.h"

@class FULLNS0NetworkCapabilities;

#ifndef DEF_FULLNS0NetworkCapabilities_H
#define DEF_FULLNS0NetworkCapabilities_H

/**
 * (no documentation provided)
 */
@interface FULLNS0NetworkCapabilities : NSObject <EnunciateXML>
{
  @private
    NSArray *_latency;
    NSArray *_link;
    NSArray *_ipAddressList;
    NSArray *_macAddressList;
    NSArray *_host;
    NSArray *_node;
    NSArray *_bandwidth;
    NSArray *_controller;
}

/**
 * (no documentation provided)
 */
- (NSArray *) latency;

/**
 * (no documentation provided)
 */
- (void) setLatency: (NSArray *) newLatency;

/**
 * (no documentation provided)
 */
- (NSArray *) link;

/**
 * (no documentation provided)
 */
- (void) setLink: (NSArray *) newLink;

/**
 * (no documentation provided)
 */
- (NSArray *) ipAddressList;

/**
 * (no documentation provided)
 */
- (void) setIpAddressList: (NSArray *) newIpAddressList;

/**
 * (no documentation provided)
 */
- (NSArray *) macAddressList;

/**
 * (no documentation provided)
 */
- (void) setMacAddressList: (NSArray *) newMacAddressList;

/**
 * (no documentation provided)
 */
- (NSArray *) host;

/**
 * (no documentation provided)
 */
- (void) setHost: (NSArray *) newHost;

/**
 * (no documentation provided)
 */
- (NSArray *) node;

/**
 * (no documentation provided)
 */
- (void) setNode: (NSArray *) newNode;

/**
 * (no documentation provided)
 */
- (NSArray *) bandwidth;

/**
 * (no documentation provided)
 */
- (void) setBandwidth: (NSArray *) newBandwidth;

/**
 * (no documentation provided)
 */
- (NSArray *) controller;

/**
 * (no documentation provided)
 */
- (void) setController: (NSArray *) newController;
@end /* interface FULLNS0NetworkCapabilities */

#endif /* DEF_FULLNS0NetworkCapabilities_H */
