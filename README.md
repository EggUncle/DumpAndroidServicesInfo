# DumpAndroidServicesInfo

dump android services info as json (without some service because of haven't root)

# how to use it

install apk & open , it will generate service_info.json in /sdcard

#example data
```
{
  "android": "8.0.0",
  "infos": [
    {
      "methodList": [
        {
          "code": 22,
          "methodName": "addNfcUnlockHandler",
          "paramTypeList": [
            "android.nfc.INfcUnlockHandler",
            "int[]"
          ]
        },
        {
          "code": 7,
          "methodName": "disable",
          "paramTypeList": [
            "boolean"
          ]
        },
        {
          "code": 10,
          "methodName": "disableNdefPush",
          "paramTypeList": []
        },
        {
          "code": 19,
          "methodName": "dispatch",
          "paramTypeList": [
            "android.nfc.Tag"
          ]
        },
        {
          "code": 8,
          "methodName": "enable",
          "paramTypeList": []
        },
        {
          "code": 9,
          "methodName": "enableNdefPush",
          "paramTypeList": []
        },
        {
          "code": 26,
          "methodName": "getCplc",
          "paramTypeList": []
        },
        {
          "code": 27,
          "methodName": "getDieId",
          "paramTypeList": []
        },
        {
          "code": 4,
          "methodName": "getNfcAdapterExtrasInterface",
          "paramTypeList": [
            "java.lang.String"
          ]
        },
        {
          "code": 5,
          "methodName": "getNfcAdapterVendorInterface",
          "paramTypeList": [
            "java.lang.String"
          ]
        },
        {
          "code": 2,
          "methodName": "getNfcCardEmulationInterface",
          "paramTypeList": []
        },
        {
          "code": 3,
          "methodName": "getNfcFCardEmulationInterface",
          "paramTypeList": []
        },
        {
          "code": 1,
          "methodName": "getNfcTagInterface",
          "paramTypeList": []
        },
        {
          "code": 6,
          "methodName": "getState",
          "paramTypeList": []
        },
        {
          "code": 18,
          "methodName": "ignore",
          "paramTypeList": [
            "int",
            "int",
            "android.nfc.ITagRemovedCallback"
          ]
        },
        {
          "code": 16,
          "methodName": "invokeBeam",
          "paramTypeList": []
        },
        {
          "code": 17,
          "methodName": "invokeBeamInternal",
          "paramTypeList": [
            "android.nfc.BeamShareData"
          ]
        },
        {
          "code": 11,
          "methodName": "isNdefPushEnabled",
          "paramTypeList": []
        },
        {
          "code": 12,
          "methodName": "pausePolling",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 23,
          "methodName": "removeNfcUnlockHandler",
          "paramTypeList": [
            "android.nfc.INfcUnlockHandler"
          ]
        },
        {
          "code": 13,
          "methodName": "resumePolling",
          "paramTypeList": []
        },
        {
          "code": 25,
          "methodName": "setAidRoute",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 15,
          "methodName": "setAppCallback",
          "paramTypeList": [
            "android.nfc.IAppCallback"
          ]
        },
        {
          "code": 14,
          "methodName": "setForegroundDispatch",
          "paramTypeList": [
            "android.app.PendingIntent",
            "android.content.IntentFilter[]",
            "android.nfc.TechListParcel"
          ]
        },
        {
          "code": 21,
          "methodName": "setP2pModes",
          "paramTypeList": [
            "int",
            "int"
          ]
        },
        {
          "code": 20,
          "methodName": "setReaderMode",
          "paramTypeList": [
            "android.os.IBinder",
            "android.nfc.IAppCallback",
            "int",
            "android.os.Bundle"
          ]
        },
        {
          "code": 24,
          "methodName": "verifyNfcPermission",
          "paramTypeList": []
        }
      ],
      "serviceClassName": "android.nfc.INfcAdapter",
      "serviceName": "nfc"
    },
    {
      "methodList": [
        {
          "code": 6,
          "methodName": "addListener",
          "paramTypeList": [
            "android.hardware.ICameraServiceListener"
          ]
        },
        {
          "code": 3,
          "methodName": "connect",
          "paramTypeList": [
            "android.hardware.ICameraClient",
            "int",
            "java.lang.String",
            "int",
            "int"
          ]
        },
        {
          "code": 4,
          "methodName": "connectDevice",
          "paramTypeList": [
            "android.hardware.camera2.ICameraDeviceCallbacks",
            "java.lang.String",
            "java.lang.String",
            "int"
          ]
        },
        {
          "code": 5,
          "methodName": "connectLegacy",
          "paramTypeList": [
            "android.hardware.ICameraClient",
            "int",
            "int",
            "java.lang.String",
            "int"
          ]
        },
        {
          "code": 8,
          "methodName": "getCameraCharacteristics",
          "paramTypeList": [
            "java.lang.String"
          ]
        },
        {
          "code": 2,
          "methodName": "getCameraInfo",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 10,
          "methodName": "getCameraVendorTagCache",
          "paramTypeList": []
        },
        {
          "code": 9,
          "methodName": "getCameraVendorTagDescriptor",
          "paramTypeList": []
        },
        {
          "code": 11,
          "methodName": "getLegacyParameters",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 1,
          "methodName": "getNumberOfCameras",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 13,
          "methodName": "isCameraInUse",
          "paramTypeList": []
        },
        {
          "code": 15,
          "methodName": "notifySystemEvent",
          "paramTypeList": [
            "int",
            "int[]"
          ]
        },
        {
          "code": 7,
          "methodName": "removeListener",
          "paramTypeList": [
            "android.hardware.ICameraServiceListener"
          ]
        },
        {
          "code": 14,
          "methodName": "setTorchMode",
          "paramTypeList": [
            "java.lang.String",
            "boolean",
            "android.os.IBinder"
          ]
        },
        {
          "code": 12,
          "methodName": "supportsCameraApi",
          "paramTypeList": [
            "java.lang.String",
            "int"
          ]
        }
      ],
      "serviceClassName": "android.hardware.ICameraService",
      "serviceName": "media.camera"
    },
    {
      "methodList": [
        {
          "code": 5,
          "methodName": "clearSecureUserId",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 1,
          "methodName": "enroll",
          "paramTypeList": [
            "int",
            "byte[]",
            "byte[]",
            "byte[]"
          ]
        },
        {
          "code": 4,
          "methodName": "getSecureUserId",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 2,
          "methodName": "verify",
          "paramTypeList": [
            "int",
            "byte[]",
            "byte[]"
          ]
        },
        {
          "code": 3,
          "methodName": "verifyChallenge",
          "paramTypeList": [
            "int",
            "long",
            "byte[]",
            "byte[]"
          ]
        }
      ],
      "serviceClassName": "android.service.gatekeeper.IGateKeeperService",
      "serviceName": "android.service.gatekeeper.IGateKeeperService"
    },
    {
      "methodList": [
        {
          "code": 3,
          "methodName": "close",
          "paramTypeList": [
            "java.lang.String",
            "java.lang.String"
          ]
        },
        {
          "code": 7,
          "methodName": "createSession",
          "paramTypeList": [
            "android.net.sip.SipProfile",
            "android.net.sip.ISipSessionListener",
            "java.lang.String"
          ]
        },
        {
          "code": 9,
          "methodName": "getListOfProfiles",
          "paramTypeList": [
            "java.lang.String"
          ]
        },
        {
          "code": 8,
          "methodName": "getPendingSession",
          "paramTypeList": [
            "java.lang.String",
            "java.lang.String"
          ]
        },
        {
          "code": 4,
          "methodName": "isOpened",
          "paramTypeList": [
            "java.lang.String",
            "java.lang.String"
          ]
        },
        {
          "code": 5,
          "methodName": "isRegistered",
          "paramTypeList": [
            "java.lang.String",
            "java.lang.String"
          ]
        },
        {
          "code": 1,
          "methodName": "open",
          "paramTypeList": [
            "android.net.sip.SipProfile",
            "java.lang.String"
          ]
        },
        {
          "code": 2,
          "methodName": "open3",
          "paramTypeList": [
            "android.net.sip.SipProfile",
            "android.app.PendingIntent",
            "android.net.sip.ISipSessionListener",
            "java.lang.String"
          ]
        },
        {
          "code": 6,
          "methodName": "setRegistrationListener",
          "paramTypeList": [
            "java.lang.String",
            "android.net.sip.ISipSessionListener",
            "java.lang.String"
          ]
        }
      ],
      "serviceClassName": "android.net.sip.ISipService",
      "serviceName": "sip"
    }          "code": 6,
          "methodName": "list",
          "paramTypeList": [
            "java.lang.String",
            "int"
          ]
        },
        {
          "code": 9,
          "methodName": "lock",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 38,
          "methodName": "onDeviceOffBody",
          "paramTypeList": []
        },
        {
          "code": 34,
          "methodName": "onUserAdded",
          "paramTypeList": [
            "int",
            "int"
          ]
        },
        {
          "code": 8,
          "methodName": "onUserPasswordChanged",
          "paramTypeList": [
            "int",
            "java.lang.String"
          ]
        },
        {
          "code": 35,
          "methodName": "onUserRemoved",
          "paramTypeList": [
            "int"
          ]
        },
        {
          "code": 7,
          "methodName": "reset",
          "paramTypeList": []
        },
        {
          "code": 14,
          "methodName": "sign",
          "paramTypeList": [
            "java.lang.String",
            "byte[]"
          ]
        },
        {
          "code": 18,
          "methodName": "ungrant",
          "paramTypeList": [
            "java.lang.String",
            "int"
          ]
        },
        {
          "code": 10,
          "methodName": "unlock",
          "paramTypeList": [
            "int",
            "java.lang.String"
          ]
        },
        {
          "code": 29,
          "methodName": "update",
          "paramTypeList": [
            "android.os.IBinder",
            "android.security.keymaster.KeymasterArguments",
            "byte[]"
          ]
        },
        {
          "code": 15,
          "methodName": "verify",
          "paramTypeList": [
            "java.lang.String",
            "byte[]",
            "byte[]"
          ]
        }
      ],
      "serviceClassName": "android.security.IKeystoreService",
      "serviceName": "android.security.keystore"
    }
    ......
    ......
    ......
    ......
    {
      "methodList": [
        {
          "code": 3,
          "methodName": "getProperty",
          "paramTypeList": [
            "int",
            "android.os.BatteryProperty"
          ]
        },
        {
          "code": 1,
          "methodName": "registerListener",
          "paramTypeList": [
            "android.os.IBatteryPropertiesListener"
          ]
        },
        {
          "code": 4,
          "methodName": "scheduleUpdate",
          "paramTypeList": []
        },
        {
          "code": 2,
          "methodName": "unregisterListener",
          "paramTypeList": [
            "android.os.IBatteryPropertiesListener"
          ]
        }
      ],
      "serviceClassName": "android.os.IBatteryPropertiesRegistrar",
      "serviceName": "batteryproperties"
    }
  ]
}
```