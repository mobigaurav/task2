/********* Multiplier.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface Multiplier : CDVPlugin {
  // Member variables go here.
}

- (void)getValue:(CDVInvokedUrlCommand*)command;
@end

@implementation Multiplier

- (void)getValue:(CDVInvokedUrlCommand*)command
{
    NSString* passedValue = [command.arguments objectAtIndex:0];
    NSInteger b = [passedValue integerValue];
    NSInteger calculatedValue = b*10;
    // Delay 2 seconds
  dispatch_after(dispatch_time(DISPATCH_TIME_NOW, (int64_t)(3.0 * NSEC_PER_SEC)), dispatch_get_main_queue(), ^{
    CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsInt:calculatedValue];
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
  });
  
}

@end
