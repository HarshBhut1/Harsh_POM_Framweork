package com.qa.app.listeners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;

public class WebEventListener implements WebDriverListener{
	
	public static Logger log = LogManager.getLogger(WebEventListener.class.getName());

	@Override
	public void beforeAnyCall(Object target, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
		
		log.error("Error has occured with Exception - : " + e);
		
	}

	@Override
	public void beforeAnyWebDriverCall(WebDriver driver, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyWebDriverCall(WebDriver driver, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeGet(WebDriver driver, String url) {
		
		log.trace("Before getting the url - " + url);
	}

	@Override
	public void afterGet(WebDriver driver, String url) {
		
		log.debug("After getting url - " + url);
	}

	@Override
	public void beforeGetCurrentUrl(WebDriver driver) {
		
	}

	@Override
	public void afterGetCurrentUrl(String result, WebDriver driver) {
		
	}

	@Override
	public void beforeGetTitle(WebDriver driver) {
		
	}

	@Override
	public void afterGetTitle(WebDriver driver, String result) {
		
	}

	@Override
	public void beforeFindElement(WebDriver driver, By locator) {
		log.trace("Before getting WebElement - " + locator.toString());
	}

	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		log.info("After getting WebElement - " + locator.toString());
	}

	@Override
	public void beforeFindElements(WebDriver driver, By locator) {
		
	}

	@Override
	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		
	}

	@Override
	public void beforeGetPageSource(WebDriver driver) {
		
	}

	@Override
	public void afterGetPageSource(WebDriver driver, String result) {
		
	}

	@Override
	public void beforeClose(WebDriver driver) {
		
	}

	@Override
	public void afterClose(WebDriver driver) {
		
	}

	@Override
	public void beforeQuit(WebDriver driver) {
		
	}

	@Override
	public void afterQuit(WebDriver driver) {
		
	}

	@Override
	public void beforeGetWindowHandles(WebDriver driver) {
	
	}

	@Override
	public void afterGetWindowHandles(WebDriver driver, Set<String> result) {
		
	}

	@Override
	public void beforeGetWindowHandle(WebDriver driver) {
		
	}

	@Override
	public void afterGetWindowHandle(WebDriver driver, String result) {
		
	}

	@Override
	public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
		
	}

	@Override
	public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
		
	}

	@Override
	public void beforeExecuteAsyncScript(WebDriver driver, String script, Object[] args) {
	
	}

	@Override
	public void afterExecuteAsyncScript(WebDriver driver, String script, Object[] args, Object result) {
		
	}

	@Override
	public void beforePerform(WebDriver driver, Collection<Sequence> actions) {
		
	}

	@Override
	public void afterPerform(WebDriver driver, Collection<Sequence> actions) {

	}

	@Override
	public void beforeResetInputState(WebDriver driver) {
		
	}

	@Override
	public void afterResetInputState(WebDriver driver) {
	
	}

	@Override
	public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyWebElementCall(WebElement element, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeClick(WebElement element) {
		
	}

	@Override
	public void afterClick(WebElement element) {
		
	}

	@Override
	public void beforeSubmit(WebElement element) {
		
	}

	@Override
	public void afterSubmit(WebElement element) {
		
	}

	@Override
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		
	}

	@Override
	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		
	}

	@Override
	public void beforeClear(WebElement element) {
		
	}

	@Override
	public void afterClear(WebElement element) {
		
	}

	@Override
	public void beforeGetTagName(WebElement element) {
		
	}

	@Override
	public void afterGetTagName(WebElement element, String result) {
		
	}

	@Override
	public void beforeGetAttribute(WebElement element, String name) {
		
	}

	@Override
	public void afterGetAttribute(WebElement element, String name, String result) {
		
	}

	@Override
	public void beforeIsSelected(WebElement element) {
	
	}

	@Override
	public void afterIsSelected(WebElement element, boolean result) {
	
	}

	@Override
	public void beforeIsEnabled(WebElement element) {
	
	}

	@Override
	public void afterIsEnabled(WebElement element, boolean result) {
	
	}

	@Override
	public void beforeGetText(WebElement element) {
	
	}

	@Override
	public void afterGetText(WebElement element, String result) {
	
	}

	@Override
	public void beforeFindElement(WebElement element, By locator) {
		
	}

	@Override
	public void afterFindElement(WebElement element, By locator, WebElement result) {
		
	}

	@Override
	public void beforeFindElements(WebElement element, By locator) {
	
	}

	@Override
	public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
		
	}

	@Override
	public void beforeIsDisplayed(WebElement element) {
		
	}

	@Override
	public void afterIsDisplayed(WebElement element, boolean result) {
	
	}

	@Override
	public void beforeGetLocation(WebElement element) {
	}

	@Override
	public void afterGetLocation(WebElement element, Point result) {
	
	}

	@Override
	public void beforeGetSize(WebElement element) {
		
	}

	@Override
	public void afterGetSize(WebElement element, Dimension result) {
		
	}

	@Override
	public void beforeGetCssValue(WebElement element, String propertyName) {
		
	}

	@Override
	public void afterGetCssValue(WebElement element, String propertyName, String result) {
		
	}

	@Override
	public void beforeAnyNavigationCall(Navigation navigation, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyNavigationCall(Navigation navigation, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeTo(Navigation navigation, String url) {
		
	}

	@Override
	public void afterTo(Navigation navigation, String url) {
		// TODO Auto-generated method stub
		WebDriverListener.super.afterTo(navigation, url);
	}

	@Override
	public void beforeTo(Navigation navigation, URL url) {
		
	}

	@Override
	public void afterTo(Navigation navigation, URL url) {
		
	}

	@Override
	public void beforeBack(Navigation navigation) {
		
	}

	@Override
	public void afterBack(Navigation navigation) {
		
	}

	@Override
	public void beforeForward(Navigation navigation) {
		
	}

	@Override
	public void afterForward(Navigation navigation) {
		
	}

	@Override
	public void beforeRefresh(Navigation navigation) {
		
	}

	@Override
	public void afterRefresh(Navigation navigation) {
		
	}

	@Override
	public void beforeAnyAlertCall(Alert alert, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyAlertCall(Alert alert, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeAccept(Alert alert) {
	
	}

	@Override
	public void afterAccept(Alert alert) {
	
	}

	@Override
	public void beforeDismiss(Alert alert) {
		
	}

	@Override
	public void afterDismiss(Alert alert) {
		
	}

	@Override
	public void beforeGetText(Alert alert) {
		
	}

	@Override
	public void afterGetText(Alert alert, String result) {
		
	}

	@Override
	public void beforeSendKeys(Alert alert, String text) {
		
	}

	@Override
	public void afterSendKeys(Alert alert, String text) {
	
	}

	@Override
	public void beforeAnyOptionsCall(Options options, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyOptionsCall(Options options, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeAddCookie(Options options, Cookie cookie) {
		
	}

	@Override
	public void afterAddCookie(Options options, Cookie cookie) {
	
	}

	@Override
	public void beforeDeleteCookieNamed(Options options, String name) {
		
	}

	@Override
	public void afterDeleteCookieNamed(Options options, String name) {
		
	}

	@Override
	public void beforeDeleteCookie(Options options, Cookie cookie) {
	
	}

	@Override
	public void afterDeleteCookie(Options options, Cookie cookie) {
		
	}

	@Override
	public void beforeDeleteAllCookies(Options options) {
		
	}

	@Override
	public void afterDeleteAllCookies(Options options) {
		
	}

	@Override
	public void beforeGetCookies(Options options) {
		
	}

	@Override
	public void afterGetCookies(Options options, Set<Cookie> result) {
		
	}

	@Override
	public void beforeGetCookieNamed(Options options, String name) {
		
	}

	@Override
	public void afterGetCookieNamed(Options options, String name, Cookie result) {
		
	}

	@Override
	public void beforeAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyTimeoutsCall(Timeouts timeouts, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeImplicitlyWait(Timeouts timeouts, Duration duration) {
		
	}

	@Override
	public void afterImplicitlyWait(Timeouts timeouts, Duration duration) {
		
	}

	@Override
	public void beforeSetScriptTimeout(Timeouts timeouts, Duration duration) {
	
	}

	@Override
	public void afterSetScriptTimeout(Timeouts timeouts, Duration duration) {
		
	}

	@Override
	public void beforePageLoadTimeout(Timeouts timeouts, Duration duration) {
	
	}

	@Override
	public void afterPageLoadTimeout(Timeouts timeouts, Duration duration) {
		
	}

	@Override
	public void beforeAnyWindowCall(Window window, Method method, Object[] args) {
		
	}

	@Override
	public void afterAnyWindowCall(Window window, Method method, Object[] args, Object result) {
		
	}

	@Override
	public void beforeGetSize(Window window) {
		
	}

	@Override
	public void afterGetSize(Window window, Dimension result) {
	
	}

	@Override
	public void beforeSetSize(Window window, Dimension size) {
		
	}

	@Override
	public void afterSetSize(Window window, Dimension size) {
		
	}

	@Override
	public void beforeGetPosition(Window window) {
		
	}

	@Override
	public void afterGetPosition(Window window, Point result) {
		
	}

	@Override
	public void beforeSetPosition(Window window, Point position) {
	
	}

	@Override
	public void afterSetPosition(Window window, Point position) {
		
	}

	@Override
	public void beforeMaximize(Window window) {
	
	}

	@Override
	public void afterMaximize(Window window) {
	
	}

	@Override
	public void beforeFullscreen(Window window) {
	
	}

	@Override
	public void afterFullscreen(Window window) {
	}
	

}
