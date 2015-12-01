/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("com.n0n1.immersive.mode.ImmersiveModeModule")["ImmersiveMode"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "ImmersiveMode";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "ImmersiveMode", "ImmersiveMode", "createImmersiveView");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"ImmersiveView": {
				get: function() {
					var ImmersiveView = lazyGet(this, "com.n0n1.immersive.mode.ImmersiveViewProxy", "ImmersiveView", "ImmersiveView");
					return ImmersiveView;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createImmersiveView = function() {
			return new module.ImmersiveView(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
