# -*- coding: utf-8 -*-

import sys
from xml.sax import handler,parseString
fields = ("topCate", "content")
import importlib
importlib.reload(sys)
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
        result = ""
        for i in fields:
            #print(i)
            if i == "topCate":
                if self.person.get(i)=='经':
                    file_handle.write('财经'+'AAA')
                elif self.person.get(i)=='内时政':
                    file_handle.write('国内时政'+'AAA')
                elif self.person.get(i)=='他':
                    file_handle.write('其他'+'AAA')
                elif self.person.get(i)=='技':
                    file_handle.write('科技'+'AAA')
                elif self.person.get(i) == '育':
                    file_handle.write('教育'+'AAA')
                elif self.person.get(i) == '政':
                    file_handle.write('时政'+'AAA')
                elif self.person.get(i) == '际时政':
                    file_handle.write('国际时政' + 'AAA')
                elif self.person.get(i) == '件':
                    file_handle.write('突发事件' + 'AAA')
                elif self.person.get(i) == '会、法制' or self.person.get(i) == '法制' or self.person.get(i) == '、法制':
                    file_handle.write('社会、法制' + 'AAA')
                elif self.person.get(i) == '乐':
                    file_handle.write('娱乐' + 'AAA')
                elif self.person.get(i) == '、健康' or self.person.get(i) == '健康':
                    file_handle.write('卫生、健康' + 'AAA')
                else:
                    file_handle.write(self.person.get(i) + 'AAA')
            else:
                file_handle.write(self.person.get(i) + '\n')
        print('第'+str(self.datanumber)+'组数据')
        # if self.datanumber >200000:
        #     file_handle.write('EOF')
        #file_handle.write('\n')
        #处理
      self.in_quote = 0
  def characters(self, content):
    #若是在tag之间的内容，更新到map中
    if self.in_quote:
      self.person.update({self.current_tag: content})

  def printKey(self):
      print(self.keySet)

if __name__ == "__main__":
    try:
      f = open("./XinhuaNewsAutoTag.v2.xml", 'r', encoding='UTF-8')
      #f1 = open("./result.txt")
      file_handle = open('./XinhuaNewsAutoTag.v2.txt', mode='w', encoding='UTF-8')
      # 如果源文件gbk  转码      若是utf-8，去掉decode.encode
      parseString(f.read().encode('utf-8'), PersonHandler(file_handle))
      #print(keySet)
      f.close()
      file_handle.close()
    except Exception as e:
        print(e)
