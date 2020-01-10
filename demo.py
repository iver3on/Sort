# -*- coding: utf-8 -*-

import sys,os
#person 处理类
from xml.sax import handler,parseString
fields = ("topCate","content")
reload(sys)
sys.setdefaultencoding('utf-8')
global linenumber

class PersonHandler(handler.ContentHandler):
  def __init__(self,file_handle):
    #存储一个news的map
    self.person = {}
    self.file_handle = file_handle
    #当前的tag
    self.current_tag = ""
    self.datanumber = 0
    #是否是tag之间的内容 ，目的拿到tag间内容，不受空白的干扰
    self.in_quote = 0
  #开始，清空map
  def startElement(self, name, attr):
    #以person，清空maps
    if name == "news":
      self.person = {}
    #记录 状态
    self.current_tag = name
    self.in_quote = 1
  #结束，插入数据库
  def endElement(self, name):
    #以news结尾  代表读取一个news的信息结束
      if name == "news":
        self.datanumber += 1
        #do something
        #in_fields = tuple([ ('"' + self.person.get(i,"") + '"')  for i in fields ])
        #print fields
        result = ""
        for i in fields:
          file_handle.write(self.person.get(i) + ' ')
        print '第'+str(self.datanumber)+'组数据'
        file_handle.write('\n')
        #处理
      self.in_quote = 0
  def characters(self, content):
    #若是在tag之间的内容，更新到map中
    if self.in_quote:
      self.person.update({self.current_tag: content})

if __name__ == "__main__":
      f = open("./data.xml")
      #f1 = open("./result.txt")
      file_handle = open('./result.txt', mode='w')
      # 如果源文件gbk  转码      若是utf-8，去掉decode.encode
      parseString(f.read().decode("gbk").encode("utf-8"), PersonHandler(file_handle))
      f.close()
      file_handle.close()
