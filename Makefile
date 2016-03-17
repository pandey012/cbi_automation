run_all_in_parallel:
	make -j test_Windows10_IE11 test_Windows8.1_firefox_40 test_Windows7_chrome_45 test_Mac_Safari	
	

test_Windows10_IE11:
	browserName="internet explorer" version=11.0 platform="Windows 10" mvn test
	
test_Windows8.1_firefox_40:
	browserName=firefox version=40.0 platform="Windows 8.1" mvn test

test_Windows7_chrome_45:
	browserName=chrome version=45.0 platform="Windows 10" mvn test
	
test_Mac_Safari:
	browserName=safari version=9.0 platform="OS X 10.11" mvn test

test_iphone6:
	browserName=iphone version=9.2 platform="OS X 10.10"  deviceName="iPhone 6" mvn test
	
test_ipad2:
	browserName=ipad  version=9.2 platform="OS X 10.10" deviceName="iPad 2" deviceOrientation="portrait"  mvn test	
		
	
