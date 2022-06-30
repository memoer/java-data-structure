from bisect import bisect_left as bl
folder = {}

def solution(info, query):
    answer, query2 = [],[]
    info = [[j for j in i.split()] for i in info]

    for i in info:
        splited(i)
    for q in query:
        check([j for j in q.split() if j != 'and'],answer)
    return answer

def splited(info):
    for a in ['-',info[0]]:
        for b in ['-',info[1]]:
            for c in ['-',info[2]]:
                for d in ['-',info[3]]:
                    if a+b+c+d in folder.keys():
                        folder[a+b+c+d].append(int(info[4]))
                    else:
                        folder[a+b+c+d] = [int(info[4])]

def check(i,answer):
    print(i)
    a = ''.join(i[:4])
    print(a)
    if a in folder.keys():
        answer.append( len(folder[a]) - bl( sorted(folder[a]), int(i[4]) ) )
    else:
        answer.append(0)

info = ["java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"]
solution(info, query)