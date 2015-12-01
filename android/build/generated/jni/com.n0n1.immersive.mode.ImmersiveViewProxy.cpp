/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This code is generated, do not edit by hand. **/

#include "com.n0n1.immersive.mode.ImmersiveViewProxy.h"

#include "AndroidUtil.h"
#include "EventEmitter.h"
#include "JNIUtil.h"
#include "JSException.h"
#include "Proxy.h"
#include "ProxyFactory.h"
#include "TypeConverter.h"
#include "V8Util.h"


#include "org.appcelerator.titanium.proxy.TiViewProxy.h"

#define TAG "ImmersiveViewProxy"

using namespace v8;

		namespace com {
		namespace n0n1 {
		namespace immersive {
		namespace mode {
			namespace immersivemode {


Persistent<FunctionTemplate> ImmersiveViewProxy::proxyTemplate = Persistent<FunctionTemplate>();
jclass ImmersiveViewProxy::javaClass = NULL;

ImmersiveViewProxy::ImmersiveViewProxy(jobject javaObject) : titanium::Proxy(javaObject)
{
}

void ImmersiveViewProxy::bindProxy(Handle<Object> exports)
{
	if (proxyTemplate.IsEmpty()) {
		getProxyTemplate();
	}

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("ImmersiveView");

	Local<Function> proxyConstructor = proxyTemplate->GetFunction();
	exports->Set(nameSymbol, proxyConstructor);
}

void ImmersiveViewProxy::dispose()
{
	LOGD(TAG, "dispose()");
	if (!proxyTemplate.IsEmpty()) {
		proxyTemplate.Dispose();
		proxyTemplate = Persistent<FunctionTemplate>();
	}

	titanium::TiViewProxy::dispose();
}

Handle<FunctionTemplate> ImmersiveViewProxy::getProxyTemplate()
{
	if (!proxyTemplate.IsEmpty()) {
		return proxyTemplate;
	}

	LOGD(TAG, "GetProxyTemplate");

	javaClass = titanium::JNIUtil::findClass("com/n0n1/immersive/mode/ImmersiveViewProxy");
	HandleScope scope;

	// use symbol over string for efficiency
	Handle<String> nameSymbol = String::NewSymbol("ImmersiveView");

	Handle<FunctionTemplate> t = titanium::Proxy::inheritProxyTemplate(
		titanium::TiViewProxy::getProxyTemplate()
, javaClass, nameSymbol);

	proxyTemplate = Persistent<FunctionTemplate>::New(t);
	proxyTemplate->Set(titanium::Proxy::inheritSymbol,
		FunctionTemplate::New(titanium::Proxy::inherit<ImmersiveViewProxy>)->GetFunction());

	titanium::ProxyFactory::registerProxyPair(javaClass, *proxyTemplate);

	// Method bindings --------------------------------------------------------

	Local<ObjectTemplate> prototypeTemplate = proxyTemplate->PrototypeTemplate();
	Local<ObjectTemplate> instanceTemplate = proxyTemplate->InstanceTemplate();

	// Delegate indexed property get and set to the Java proxy.
	instanceTemplate->SetIndexedPropertyHandler(titanium::Proxy::getIndexedProperty,
		titanium::Proxy::setIndexedProperty);

	// Constants --------------------------------------------------------------
	JNIEnv *env = titanium::JNIScope::getEnv();
	if (!env) {
		LOGE(TAG, "Failed to get environment in ImmersiveViewProxy");
		//return;
	}


		jfieldID fieldUI_FLAG_HIDE_NAVIGATION = env->GetStaticFieldID (javaClass, "UI_FLAG_HIDE_NAVIGATION", "I");
		jint fieldValueUI_FLAG_HIDE_NAVIGATION = env->GetStaticIntField(javaClass, fieldUI_FLAG_HIDE_NAVIGATION);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_HIDE_NAVIGATION", fieldValueUI_FLAG_HIDE_NAVIGATION);


		jfieldID fieldUI_FLAG_LAYOUT_FULLSCREEN = env->GetStaticFieldID (javaClass, "UI_FLAG_LAYOUT_FULLSCREEN", "I");
		jint fieldValueUI_FLAG_LAYOUT_FULLSCREEN = env->GetStaticIntField(javaClass, fieldUI_FLAG_LAYOUT_FULLSCREEN);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_LAYOUT_FULLSCREEN", fieldValueUI_FLAG_LAYOUT_FULLSCREEN);


		jfieldID fieldUI_FLAG_IMMERSIVE = env->GetStaticFieldID (javaClass, "UI_FLAG_IMMERSIVE", "I");
		jint fieldValueUI_FLAG_IMMERSIVE = env->GetStaticIntField(javaClass, fieldUI_FLAG_IMMERSIVE);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_IMMERSIVE", fieldValueUI_FLAG_IMMERSIVE);


		jfieldID fieldUI_FLAG_FULLSCREEN = env->GetStaticFieldID (javaClass, "UI_FLAG_FULLSCREEN", "I");
		jint fieldValueUI_FLAG_FULLSCREEN = env->GetStaticIntField(javaClass, fieldUI_FLAG_FULLSCREEN);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_FULLSCREEN", fieldValueUI_FLAG_FULLSCREEN);


		jfieldID fieldSYSTEM_UI_FLAG_LOW_PROFILE = env->GetStaticFieldID (javaClass, "SYSTEM_UI_FLAG_LOW_PROFILE", "I");
		jint fieldValueSYSTEM_UI_FLAG_LOW_PROFILE = env->GetStaticIntField(javaClass, fieldSYSTEM_UI_FLAG_LOW_PROFILE);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "SYSTEM_UI_FLAG_LOW_PROFILE", fieldValueSYSTEM_UI_FLAG_LOW_PROFILE);


		jfieldID fieldUI_FLAG_LAYOUT_HIDE_NAVIGATION = env->GetStaticFieldID (javaClass, "UI_FLAG_LAYOUT_HIDE_NAVIGATION", "I");
		jint fieldValueUI_FLAG_LAYOUT_HIDE_NAVIGATION = env->GetStaticIntField(javaClass, fieldUI_FLAG_LAYOUT_HIDE_NAVIGATION);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_LAYOUT_HIDE_NAVIGATION", fieldValueUI_FLAG_LAYOUT_HIDE_NAVIGATION);


		jfieldID fieldUI_FLAG_LAYOUT_STABLE = env->GetStaticFieldID (javaClass, "UI_FLAG_LAYOUT_STABLE", "I");
		jint fieldValueUI_FLAG_LAYOUT_STABLE = env->GetStaticIntField(javaClass, fieldUI_FLAG_LAYOUT_STABLE);
		DEFINE_NUMBER_CONSTANT(prototypeTemplate, "UI_FLAG_LAYOUT_STABLE", fieldValueUI_FLAG_LAYOUT_STABLE);



	// Dynamic properties -----------------------------------------------------

	// Accessors --------------------------------------------------------------

	return proxyTemplate;
}

// Methods --------------------------------------------------------------------

// Dynamic property accessors -------------------------------------------------


			} // namespace immersivemode
		} // mode
		} // immersive
		} // n0n1
		} // com
