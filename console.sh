./create-emulator.sh
Boot Status:
+ '[' '' == 1 ']'
+ sleep 1
+ '[' false == false ']'
++ /Library/Android/sdk/platform-tools/adb wait-for-device shell getprop sys.boot_completed
++ tr -d '\r'
+ status=
+ echo 'Boot Status: '
................
Boot Status:
+ '[' '' == 1 ']'
+ sleep 1
+ '[' false == false ']'
++ /Library/Android/sdk/platform-tools/adb wait-for-device shell getprop sys.boot_completed
++ tr -d '\r'
emulator: INFO: boot completed
emulator: INFO: boot time 29965 ms