from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys 
from selenium.webdriver.support.ui import WebDriverWait
import time
from selenium.webdriver.support import expected_conditions as EC
import random
import string

def grs(length):
    characters = string.ascii_letters + string.digits + string.punctuation
    random_string = ''.join(random.choice(characters) for _ in range(length))
    return random_string

def generate_random_email():
    username_length = random.randint(5, 10)
    domain_length = random.randint(5, 8)

    username = ''.join(random.choice(string.ascii_lowercase + string.digits) for _ in range(username_length))
    domain = ''.join(random.choice(string.ascii_lowercase) for _ in range(domain_length))

    email = f"{username}@{domain}.com"
    return email


i=1

while i <= 5 :


 chrome_options = Options()
 chrome_options.add_experimental_option("detach", True)
 driver = webdriver.Chrome( chrome_options )
 driver.get("http://localhost:8080/sss/serv")

 print("Début attente")
 
 time.sleep(0.5)  # Attente de 3 secondes

 print("Fin d'attente")

 f_name = driver.find_element(By.CSS_SELECTOR,"#fullName")
 username = driver.find_element(By.CSS_SELECTOR,"#username")
 email = driver.find_element(By.CSS_SELECTOR,"#email")
 phoneNumber = driver.find_element(By.CSS_SELECTOR,"#phoneNumber")
 password = driver.find_element(By.CSS_SELECTOR,"#password")
 confirmPassword = driver.find_element(By.CSS_SELECTOR,"#confirmPassword")
 male = driver.find_element(By.CSS_SELECTOR,"#male")
 female = driver.find_element(By.CSS_SELECTOR,"#female") 
 registre = driver.find_element(By.CSS_SELECTOR,"body > div > form > div.form-submit-btn > input[type=submit]")

#saisir les données 

 f_name.send_keys(grs(10))
 username.send_keys(grs(5))
 email.send_keys(generate_random_email())
 phoneNumber.send_keys("0696353700")
 pas = grs(10)
 password.send_keys(pas)
 confirmPassword.send_keys(pas)
 male.click() 
 registre.click()

 i = i+1 
  
 driver.quit()