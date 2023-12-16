
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys 
from selenium.webdriver.support.ui import WebDriverWait
import time


print("Début attente")

time.sleep(3)  # Attente de 3 secondes

print("Fin d'attente ")

chrome_options = Options()
chrome_options.add_experimental_option("detach", True)
driver = webdriver.Chrome( chrome_options )

driver.get("https://www.decathlon.ma")

promo = driver.find_element(By.CSS_SELECTOR,"#soomagicmenu-main > ul > li.root.root-12.bkg-price-reduction > div > a > div")

print("\n")

print(promo.text)

promo.click()

print("Début attente")

time.sleep(3)  # Attente de 3 secondes

print("Fin d'attente ")

#varibale_2 = driver.find_elements(By.TAG_NAME,"li")

varibale_2 = driver.find_element(By.CSS_SELECTOR ,"#category-hits > div > div > ol > li:nth-child(1) > div > div > div > div > div:nth-child(4) > div > div.block__price > span.price")

varibale_3 = driver.find_element(By.CSS_SELECTOR ,"#category-hits > div > div > ol > li:nth-child(1) > div > div > div > div > div:nth-child(4) > div > h3 > a")

j= 1

while varibale_2  :
    my_string_1 = f"#category-hits > div > div > ol > li:nth-child({j}) > div > div > div > div > div:nth-child(4) > div > h3 > a "
    my_string_2 = f"#category-hits > div > div > ol > li:nth-child({j}) > div > div > div > div > div:nth-child(4) > div > div.block__price > span.price"
    varibale_2 = driver.find_elements(By.CSS_SELECTOR , my_string_1)
    varibale_3 = driver.find_elements(By.CSS_SELECTOR ,my_string_2)
    for var in varibale_2 :
      print(var.text)
    for var in varibale_3 :
      print(var.text)  
    j = j+1  
   
print("Nombre d'élement tirer est ",j-2)









